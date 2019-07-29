package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get attribute from container using getAttribute
		//ServletContext sc=getServletContext();
		HttpSession sc=request.getSession(true);
		String userid=sc.getAttribute("id").toString();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center>");
		out.println("Welcome from LoginServlet1  "+userid);
		out.println("<br>session id is "+sc.getId());
		out.println("<br>session creation time is "+new Date(sc.getCreationTime()));
		out.println("<br>session last access time is "+new Date(sc.getLastAccessedTime()));
		sc.setMaxInactiveInterval(15000);
		out.println("<br><a href=LogoutServlet>log out</a>");
				
		out.println("</center></body></html>");
	}

}









