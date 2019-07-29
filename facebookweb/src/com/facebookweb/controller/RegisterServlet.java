package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.dao.FacebookWebDAO;
import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.entity.FacebookLogin;

public class RegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String age=request.getParameter("age");
		String dob=request.getParameter("dob");
		String g=request.getParameter("g");
		String country=request.getParameter("country");
		String state=request.getParameter("state");
		String profile=request.getParameter("profile");
		
		String hobbies[]=request.getParameterValues("h");
		
		FacebookEmployee fe=new FacebookEmployee();
		fe.setAddress(address);
		fe.setAge(age);
		fe.setCountry(country);
		fe.setDob(dob);
		fe.setEmail(email);
		fe.setGender(g);
		fe.setHobbies(hobbies);
		fe.setName(name);
		fe.setPass(pass);
		fe.setProfile(profile);
		fe.setState(state);
		
		FacebookWebDAOInterface fd=FacebookWebDAO.createObject();
		FacebookLogin i=fd.createProfileDAO(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		if(i!=null){
			out.println("<br>Hello -- >"+name);
			out.println("<br>Registration Successful");
			out.println("<br> Your userid is -->"+i.getUserId());
			out.println("<br> Your Password is -->"+i.getUserPassword());
			out.println("<br>To continue <a href=login.html>Click Here</a>");
		}
		else{
			out.println("<br>Registration unsuccessful");
		}
						
		out.println("</center></body></html>");
		
		
	}

}









