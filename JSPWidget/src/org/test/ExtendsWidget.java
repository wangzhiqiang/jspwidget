package org.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.widget.Widget;

public class ExtendsWidget extends Widget {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {


		return this.forward("test.jsp", request, response);
	}


}
