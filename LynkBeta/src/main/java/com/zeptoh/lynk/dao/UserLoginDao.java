package com.zeptoh.lynk.dao;

import com.zeptoh.lynk.model.UserRegistration;

public interface UserLoginDao {
	public UserRegistration getUserLogin(String uName, String pwd);

}
