/**
 * 
 */
package com.zeptoh.lynk.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import com.zeptoh.lynk.dao.URLDaoImpl;
import com.zeptoh.lynk.model.SelectedContent;

/**
 * @author zeptoh
 *
 */
public class URLServiceImpl implements URLService {

	private URLDaoImpl daoImpl = new URLDaoImpl();

	public String getResponse(String url, String lynkType, SelectedContent lynk, String lynkUrl) throws ProtocolException,
			MalformedURLException, IOException {
		return daoImpl.getResponse(url, lynkType, lynk, lynkUrl);
	}

}
