/**
 * 
 */
package com.zeptoh.lynk.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import com.zeptoh.lynk.model.SelectedContent;

/**
 * @author zeptoh
 *
 */
public interface URLService {
	public String getResponse(String url, String lynkType, SelectedContent lynk, String lynkUrl) throws MalformedURLException,
			ProtocolException, IOException;
}
