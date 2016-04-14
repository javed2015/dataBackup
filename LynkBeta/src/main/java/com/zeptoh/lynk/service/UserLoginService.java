package com.zeptoh.lynk.service;

import com.zeptoh.lynk.model.UserRegistration;

public interface UserLoginService {
	public UserRegistration getUserLogin(String uName, String pwd);
}
