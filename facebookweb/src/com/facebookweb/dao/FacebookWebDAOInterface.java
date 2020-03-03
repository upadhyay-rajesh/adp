package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.Customer;
import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.entity.FacebookLogin;

public interface FacebookWebDAOInterface {

	FacebookLogin createProfileDAO(FacebookEmployee fe);

	boolean checkLogin(FacebookLogin fl);

	List<Country> loadCountryDAO();

	List<Customer> checkBalance();

}
