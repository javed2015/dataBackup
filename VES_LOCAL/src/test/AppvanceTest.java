package test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class AppvanceTest{

	

	
	public static Connection ConnectionProv() throws ClassNotFoundException {
		Connection con=null;
		final String username = "sys as sysdba";
		final String password = "admin";
	//	final String driver = "com.mysql.jdbc.Driver";
		final String driver = "oracle.jdbc.driver.OracleDriver";
		
		final String connectionStirng = "jdbc:oracle:thin:@localhost:1521:xe";
	//	final String connectionStirng = "jdbc:mysql://127.0.0.1:3306/instant";
		
			try{
				Class.forName(driver);
			    con = DriverManager.getConnection(connectionStirng,username,password);
			   
			}catch(SQLException e) {e.printStackTrace();}
			return con;
		
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
	Connection con = null;
	con = AppvanceTest.ConnectionProv();
	PreparedStatement ps=null;
	
	int idCount=11;
	int code = 1011;
	int slno;
		
	try {		
		String sqlQuery = "insert into WINAPPCODE(ID,CODE,STATUS) values(?,?,?)";	
		for (int i=1;i<=1000;i++){
			slno=idCount+i;
			int appcode=code+i;
			String winAppCode="WINAPP"+appcode;
		ps = con.prepareStatement(sqlQuery);
		 ps.setInt(1, slno);
	    	ps.setString(2, winAppCode);
	    	ps.setInt(3, 0);
	    	ps.executeUpdate();  
	    	ps.close();
	    	con.close();
	    //	Thread.sleep(1000);
	    	}
	    	
	}  catch (SQLException e) {		
		e.printStackTrace();
	}finally{		
			ps.close();	
		con.close();
	}
	
	
}
}



