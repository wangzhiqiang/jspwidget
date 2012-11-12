package org.test;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.widget.Widget;

public class ExtendsWidget extends Widget {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		 
		return this.forward("test.jsp", request, response);
	}

	 

}
