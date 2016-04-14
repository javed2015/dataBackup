/**
 * 
 */
package com.zeptoh.lynk.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.zeptoh.lynk.common.CommonDaoImpl;
import com.zeptoh.lynk.model.UserRegistration;

/**
 * @author zeptoh
 *
 */
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Override
	public boolean userAvailability(String uName) {
		// TODO Auto-generated method stub
		EntityManager entityManager = CommonDaoImpl.setUpEntityManagerFactory().createEntityManager();
		
		try {
			Query query = entityManager.createNativeQuery("db.Login.find( { \"E_MAIL\": \""+uName+"\",\"FLAG\": \"True\" } )", UserRegistration.class);
			UserRegistration authors = (UserRegistration) query.getSingleResult();
			if (authors != null) {
				return true;
			}else{
			return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			  entityManager.close();
			  CommonDaoImpl.closeEntityManagerFactory();
			 }
	}
	
	@Override
	public void storeUserDetails(Object obj) {
		// TODO Auto-generated method stub
		CommonDaoImpl cdi = new CommonDaoImpl();
		cdi.storeLynk(obj);
	}

}
