package test;
import java.sql.*;

import com.votsh.support.ConnectionProvider;

public class DbTest {
	public static void main(String[] args){	
	
Connection con;
Statement st=null;
String dataSample = "null";
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
	        "sys as sysdba", "admin");	
	//con=ConnectionProvider.getConnection();
	

	String sqlQuery = "SELECT DP.SL_NO,DP.USER_NAME,DP.PROJECT_NAME,DP.ACCESS_ALLOWED  FROM VES_DEMO_PROJECTS DP, USER_DETAILS UD WHERE DP.USER_NAME=UD.USER_NAME";
	st = con.createStatement();
	ResultSet rs=null;	
	System.out.println(rs);
	
	rs = st.executeQuery(sqlQuery);			
	String[] user_name = new String[1];
	String[] project_name = new String[1];
	String[] access_allowed = new String[1];
	String[] sl_no = new String[1];		
	int rows=0;
	
			
	while(rs.next()){
			user_name[0] = rs.getString("USER_NAME");
			project_name[0]  = rs.getString("PROJECT_NAME");
			access_allowed[0]     = rs.getString("ACCESS_ALLOWED");
			sl_no[0]  = rs.getString("SL_NO");					
		int count= ++rows;		
		dataSample=dataSample+"{ id:"+count+", data: ["+'"'+sl_no[0]+'"'+", "+'"'+user_name[0]+'"'+", "+'"'+project_name[0]+'"'+", "+'"'+access_allowed[0]+'"'+"]},";
	}
	if(dataSample.endsWith(","))
	{
		dataSample = dataSample.substring(0,dataSample.length() - 1)+"]}";
	}
	if(dataSample.startsWith("null"))
	{
		dataSample = "{rows:["+dataSample.substring(4,dataSample.length());
	}
	System.out.println(dataSample);
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
