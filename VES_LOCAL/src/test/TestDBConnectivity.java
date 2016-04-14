package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.votsh.support.ConnectionProvider;

public class TestDBConnectivity {
	static Connection con =null;
	

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse("2012-12-13 14:54:30"); // mysql datetime format
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);		
		String datetime = format.format(calendar.getTime());		
		String str[]={"1","2","3"};
		String str1="";
		int i=1;
		while(i<=str.length) {
			str1 =str1 + str[i-1];
			i++;
		}		
		System.out.println(str1);
		
	}

}
