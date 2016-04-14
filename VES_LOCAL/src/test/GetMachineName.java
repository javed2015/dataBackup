package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class GetMachineName {

	public static void main(String[] args) {
		URL url = null;
		BufferedReader in = null;
		String ipAddress = "";
		try {
			url = new URL("http://checkip.amazonaws.com");
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			ipAddress = in.readLine().trim();
			}catch (Exception exp) {
				ipAddress = "ERROR";
			}
		
		
		System.out.println("IP Address: " + ipAddress);
	
	}
	
	
}
