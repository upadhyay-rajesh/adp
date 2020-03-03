package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.Customer;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.entity.FacebookLogin;

public class FacebookWebDAO implements FacebookWebDAOInterface {

	public static FacebookWebDAOInterface createObject() {
		
		return new FacebookWebDAO();
	}

	private Connection con;
	public FacebookWebDAO(){
		try{
		//step 1 load driver
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				//step 2 create connection with database
				con=DriverManager.getConnection("jdbc:derby:C:\\Users\\Dell\\hsbc_db1;create=true");
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public FacebookLogin createProfileDAO(FacebookEmployee e)  {
		int i=0;
		FacebookLogin fl=null;
		try{
		//step 3 create query
		PreparedStatement ps=con.prepareStatement(
				"insert into HSBC_FIRST.FACEBOOK values(?,?,?,?,?)");
		ps.setInt(1, (int)(Math.random()*10000));
		ps.setString(2, e.getName());
		ps.setString(3, e.getPass());
		ps.setString(4, e.getEmail());
		ps.setString(5, e.getAddress());
		
		//step 4 execute query
		i=ps.executeUpdate();
		
		PreparedStatement ps1=con.prepareStatement(
				"select * from HSBC_FIRST.FACEBOOK");
		ResultSet res=ps1.executeQuery();
		int i1=0;
		while(res.next()){
			i1=res.getInt(1);
		}
		String newid=i1+e.getName().substring(0,3)+(int)((Math.random())*100);
		
		PreparedStatement ps3=con.prepareStatement(
				"insert into HSBC_FIRST.login values(?,?)");
		ps3.setString(1, newid);
		ps3.setString(2, e.getPass());
		int res1=ps3.executeUpdate();
		if(res1>0){
			fl=new FacebookLogin();
			fl.setUserId(newid);
			fl.setUserPassword(e.getPass());
		}
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		return fl;
	}

	@Override
	public boolean checkLogin(FacebookLogin fl) {
		boolean b=false;
		try{
			//step 3 create query
			PreparedStatement ps=con.prepareStatement(
					"select * from HSBC_FIRST.login where userid=? and password=?");
			ps.setString(1, fl.getUserId());
			ps.setString(2, fl.getUserPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()){
				b=true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Country> loadCountryDAO() {
		List<Country> b=new ArrayList<Country>();
		try{
			//step 3 create query
			PreparedStatement ps=con.prepareStatement(
					"select * from HSBC_FIRST.country");
			ResultSet res=ps.executeQuery();
			while(res.next()){
				Country c=new Country();
				c.setCountryId(res.getString(1));
				c.setCountryName(res.getString(2));
				
				b.add(c);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Customer> checkBalance() {
		List<Customer> b=new ArrayList<Customer>();
		try{
			//step 3 create query
			PreparedStatement ps=con.prepareStatement(
					"select * from HSBC_FIRST.Customer where balance<'"+10000+"'");
			ResultSet res=ps.executeQuery();
			while(res.next()){
				Customer c=new Customer();
				c.setName(res.getString(1));
				c.setAddress(res.getString(2));
				c.setBalance(Double.parseDouble(res.getString(3)));
				b.add(c);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	
}




