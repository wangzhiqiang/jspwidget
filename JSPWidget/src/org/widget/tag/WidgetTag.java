package org.widget.tag;

import java.lang.reflect.Method;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

final public class WidgetTag extends TagSupport {
	/**
	 *  
	 */
	private static final long serialVersionUID = 3268933179073293342L;

	private String name; // package.class
	private String key;
	private Object value;
	private String function = "run"; // default function

	@Override
	public int doStartTag() throws JspException {
		// 获取jsp输出对象
		JspWriter jspOut = this.pageContext.getOut();
		// 获取request 和response
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) this.pageContext.getResponse();
		// 接收参数写入response
		if ((key != null && !key.equals(""))
				&& (value != null && !value.equals("")))
			request.setAttribute(key, value);

		Class<?> c = null;
		Object obj = null;
		Method[] methods = null;
		try {
			// 加载class
			c = Class.forName(name);
			// 得到实例化对象
			obj = c.newInstance();
			// 获取对象的所有方法
			methods = c.getDeclaredMethods();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 遍历方法
		for (int i = 0; i < methods.length; i++) {
			@SuppressWarnings("rawtypes")
			// 获取方法参数类型
			Class[] types = methods[i].getParameterTypes();
			Object[] values = new Object[types.length];
			for (int j = 0; j < types.length; j++) {
				// 传参
				if (HttpServletRequest.class == types[j])
					values[j] = request;
				if (HttpServletResponse.class == types[j])
					values[j] = response;
			}
			// 执行方法 输出页面code
			if (methods[i].getName().equals(function)) {
				try {
					jspOut.write((String) methods[i].invoke(obj, values));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
