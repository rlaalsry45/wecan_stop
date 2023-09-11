package com.z5.zcms.util.parsingjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletUsingCustomResponse extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String template = (String) req.getAttribute("tmpl");

		CharArrayWriterResponse customResponse = new CharArrayWriterResponse(resp);
		req.getRequestDispatcher(template).forward(req, customResponse);
		System.out.println("customResponse.getOutput()):"+customResponse.getOutput());

		System.out.println(String.format("The output of %s is %s", template, customResponse.getOutput()));
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp, String body)
			throws ServletException, IOException {
		String template = body;

		CharArrayWriterResponse customResponse = new CharArrayWriterResponse(resp);
		req.getRequestDispatcher(template).forward(req, customResponse);

		System.out.println(String.format("The output of %s is %s", template, customResponse.getOutput()));
	}
}