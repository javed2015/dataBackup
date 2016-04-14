/**
 * 
 */
package com.zeptoh.lync.LynkBeta;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ZEPTOH
 *
 */
public class urtestl {

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String inr = "http://142.4.25.127:8080/LynkBeta/web_link/source/token/pm33n94hlb7khh2jiqnastg54o";
		URL url = new URL(inr);

		
		String wer = url.getProtocol()+"://"+url.getHost()+":"+url.getPort()+"/LynkBeta";

	}

}
