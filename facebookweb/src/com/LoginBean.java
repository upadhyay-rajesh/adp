package com;

import com.facebookweb.dao.FacebookWebDAO;
import com.facebookweb.dao.FacebookWebDAOInterface;
import com.facebookweb.entity.FacebookLogin;

public class LoginBean {
	public LoginBean(){}
	private String uid;
	private String pass;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean login(){
		FacebookLogin fl=new FacebookLogin();
		fl.setUserId(uid);
		fl.setUserPassword(pass);
		FacebookWebDAOInterface fd=FacebookWebDAO.createObject();
		boolean b=fd.checkLogin(fl);
		return b;
	}
}











