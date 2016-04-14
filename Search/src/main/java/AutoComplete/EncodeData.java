package AutoComplete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class EncodeData {

	/*public static void main(String[] args) {
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
	
	}*/
	
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
		
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date dateobj = new Date();
			System.out.println(df.format(dateobj));
			   
			//get Calendar instance
			Calendar now = Calendar.getInstance();
   
			//get current TimeZone using getTimeZone method of Calendar class
			TimeZone timeZone = now.getTimeZone();
   
			//display current TimeZone using getDisplayName() method of TimeZone class
			System.out.println("Current TimeZone is : " + timeZone.getDisplayName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	
	
}

