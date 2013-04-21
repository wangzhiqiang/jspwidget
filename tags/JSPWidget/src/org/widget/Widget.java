package org.widget;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.widget.common.ImportHttpServletResponseWrapper;

public abstract class Widget {
	
	public abstract String run(HttpServletRequest request,
			HttpServletResponse response);
	 
	//跳转的url 返回页面内容
	public String forward(String url, HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		ImportHttpServletResponseWrapper ihrw = new ImportHttpServletResponseWrapper(
				response);
		try { 
			rd.include(request, ihrw);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ihrw.getString();
	}

}
