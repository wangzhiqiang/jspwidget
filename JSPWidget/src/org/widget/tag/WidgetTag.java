package org.widget.tag;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class WidgetTag extends TagSupport {
	/**
	 * 核心tag
	 */
	private static final long serialVersionUID = 3268933179073293342L;
	// 定义接收参数
	private String name; // 加载完整Class名
	private String key; // 参数
	private Object value;
	private String function = "run"; // default function

	@Override
	public int doStartTag() throws JspException {

		JspWriter jspOut = this.pageContext.getOut();

		HttpServletRequest request = (HttpServletRequest) this.pageContext
				.getRequest();

		HttpServletResponse response = (HttpServletResponse) this.pageContext
				.getResponse();
		if((key!=null && !key.equals(""))&&(value!=null && !value.equals("")))
			request.setAttribute(key, value);
		
		
		Class<?> c = null;
		try {
			c = Class.forName(name); // 加载class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Object obj = null;
		try {
			obj = c.newInstance(); // 得到实例化对象
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Method[] methods = c.getDeclaredMethods(); // 得到全体方法数组

		for (int i = 0; i < methods.length; i++) {
			@SuppressWarnings("rawtypes")
			Class[] types = methods[i].getParameterTypes();// 获取方法参数类型
			Object[] values = new Object[types.length];
			for (int j = 0; j < types.length; j++) {
				if (HttpServletRequest.class == types[j])
					values[j] = request;
				if (HttpServletResponse.class == types[j])
					values[j] = response;
			}
			if (methods[i].getName().equals(function)) {
				try {
					// 执行 方法 反回页面输出
					jspOut.write((String) methods[i].invoke(obj, values));

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (IOException e) {
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
