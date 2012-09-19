package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this+"--doPost");
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");

		System.out.println("test");
//	response.sendRedirect("/test.jsp");
		request.setAttribute("name", "test -- name -- value");
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}
}