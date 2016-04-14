/**
 * 
 */
package com.zeptoh.lynk.service;


/**
 * @author zeptoh
 *
 */
public interface UserRegistrationService {
	public boolean userAvailability(String uName);
	public void storeUserDetails(Object obj);
}
