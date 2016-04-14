package com.zeptoh.lynk.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.zeptoh.lynk.common.CommonDaoImpl;
import com.zeptoh.lynk.model.UserRegistration;

public class UserLoginDaoImpl implements UserLoginDao{
 
 
 @Override
 public UserRegistration getUserLogin(String uName, String pwd) {
  // TODO Auto-generated method stub
	 UserRegistration userDetail = null;
	 EntityManager entityManager = CommonDaoImpl.setUpEntityManagerFactory().createEntityManager();
		
	 try {
		Query query = entityManager.createNativeQuery("db.Login.find( { \"E_MAIL\": \""+uName+"\" } )", UserRegistration.class);
		
		userDetail = (UserRegistration) query.getSingleResult();
		String pWord = userDetail.getPassword();
		String[] str = pWord.split(":");
		  String salt = str[0];
		 if((salt+":"+PasswordHashing.get_SHA_1_SecurePassword(pwd, salt)).equals(pWord)){
			 return userDetail;
			  } else{
				 return userDetail = null;
			  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return userDetail = null;
	}finally{
		  entityManager.close();
		  CommonDaoImpl.closeEntityManagerFactory();
		 }
 }

}