package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.facebookweb.dao.FacebookWebDAO;
import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.entity.Customer;

public class HsbcTagBalance extends TagSupport{
	public int doStartTag(){
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag(){
		FacebookWebDAOInterface fd=FacebookWebDAO.createObject();
		List<Customer> b=fd.checkBalance();
		JspWriter out=pageContext.getOut();
		try{
		
		out.write("<html><body><center><table border=5>");
		out.write("<tr><th>NAME</th><th>ADDRESS</th><th>BALANCE</th></tr>");
		for(Customer c:b){
			out.write("<tr><td>"+c.getName()+"</td><td>"+c.getAddress()+
					"</td><td>"+c.getBalance()+"</td>");
		}
		out.write("</table></center></body></html>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
}







