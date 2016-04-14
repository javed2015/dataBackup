/**
 * 
 */
package com.zeptoh.lynk.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import com.zeptoh.lynk.model.SelectedContent;

/**
 * @author zeptoh
 *
 */
public interface URLDao {
	public String getResponse(String url1, String lynkType, SelectedContent lynk, String context) throws ProtocolException,
			MalformedURLException, IOException;
}
