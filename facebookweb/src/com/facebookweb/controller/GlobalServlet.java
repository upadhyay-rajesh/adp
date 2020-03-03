package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.dao.FacebookWebDAO;
import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookLogin;

public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("action");
		
		if(a.equals("loadcountry")){
			FacebookWebDAOInterface fd=FacebookWebDAO.createObject();
			List<Country> i=fd.loadCountryDAO();
			
			String s="[";
			for(Country cc:i){
				s=s+"{\"countryId\":\""+cc.getCountryId()+"\" "
						+ ",\"countryName\":\""+cc.getCountryName()+"\"},";
			}
			s=s.substring(0, s.length()-1);
			s=s+"]";
			System.out.println(s);
			PrintWriter out=response.getWriter();
			out.println(s);
		}
	}

}
