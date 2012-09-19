package org.widget;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.widget.common.ImplHttpServletResponseWrapper;

public abstract class Widget {
	
	public abstract String run(HttpServletRequest request,
			HttpServletResponse response);
	/**
	 * 重新实现的forward 方法，不执行跳转，返回页面输出内容
	 * @param url 跳转地址  可以是action也可以是jsp 
	 * @param request
	 * @param response
	 * @return 页面输出内容
	 */
	public String forward(String url, HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		ImplHttpServletResponseWrapper sres = new ImplHttpServletResponseWrapper(
				response);
		try { 
			rd.include(request, sres);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sres.getString();
	}

}
