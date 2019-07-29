package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.dao.FacebookWebDAO;
import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.entity.FacebookLogin;

public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><center>");
		
		
		String userid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		
		FacebookLogin fl=new FacebookLogin();
		fl.setUserId(userid);
		fl.setUserPassword(pass);
		
		FacebookWebDAOInterface fd=FacebookWebDAO.createObject();
		boolean b=fd.checkLogin(fl);
		if(b){
			//share attribute with container using setAttribute
			//ServletContext sc=getServletContext();
			HttpSession sc=request.getSession(true);
			sc.setAttribute("id", userid);
			
			//calling other servlet,jsp,html from servlet using RequestDispatcher
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/LoginServlet1");
			rd.forward(request, response);
			
			
		}
		else{
			out.println("Invalid id and password ");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		
		out.println("</center></body></html>");
	}

}







