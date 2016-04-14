package com.votsh.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;


import com.votsh.support.ConnectionProvider;

public class NewLivingApp {

	public String updateNewLivingApp(String username, String name_of_the_type,
			String gurl, String mname)throws SQLException {
		String Status="Success";
		Connection con = null;
		PreparedStatement prSt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			String query = ("SELECT GITHUB_USERNAME,GITHUB_PASSWORD FROM USER_DETAILS where USER_NAME=?");  
			prSt = con.prepareStatement(query);
			prSt.setString(1, username);
			rs = prSt.executeQuery();
			while(rs.next()){
				String gitUsrName = rs.getString("GITHUB_USERNAME");
				String gitPwd = rs.getString("GITHUB_PASSWORD");

			String sqlQuery = ("insert into VES_LIVING_APP (ID,USER_NAME,NAME_OF_THE_TYPE,GITHUB_URL,MACHINE_NAME,GITHUB_USER_NAME,GITHUB_PASSWORD) VALUES(VES_LIVING_APP_SN.nextval,?,?,?,?,?,?)");
			prSt = con.prepareStatement(sqlQuery);
			prSt.setString(1, username);
			prSt.setString(2, name_of_the_type);
			prSt.setString(3, gurl);
			prSt.setString(4, mname);
			prSt.setString(5, gitUsrName);
			prSt.setString(6, gitPwd);
			prSt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			prSt.close();
			con.close();
		}
		return Status;
	}
}

