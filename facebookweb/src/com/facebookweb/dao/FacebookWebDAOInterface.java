package com.facebookweb.dao;

import com.facebookweb.entity.FacebookEmployee;
import com.facebookweb.entity.FacebookLogin;

public interface FacebookWebDAOInterface {

	FacebookLogin createProfileDAO(FacebookEmployee fe);

	boolean checkLogin(FacebookLogin fl);

}
