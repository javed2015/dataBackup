/**
 * 
 */
package com.zeptoh.lynk.service;

import com.zeptoh.lynk.dao.UserLoginDaoImpl;
import com.zeptoh.lynk.model.UserRegistration;


public class UserLoginServiceImpl implements UserLoginService {


	@Override
	public UserRegistration getUserLogin(String uName, String pwd) {
		// TODO Auto-generated method stub
	
		UserLoginDaoImpl uldi = new UserLoginDaoImpl();
		return uldi.getUserLogin(uName,pwd);
		
	}


}
