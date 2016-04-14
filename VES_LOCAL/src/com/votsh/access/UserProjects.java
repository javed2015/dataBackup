package com.votsh.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.votsh.support.ConnectionProvider;

public class UserProjects {
	
	public void updateUserProjects(String userid, String projname,
			String unId, String proj_type) throws SQLException {
	
		
		String createdBy = userid;
		String pName = projname;
		String uniqueId = unId;
		String pType = proj_type;
		
		Connection con = null;
		PreparedStatement prSt = null;
		try {
			con = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {

			String sqlQuery = ("insert into USER_PROJECTS (ID,CREATED_BY,PROJECT_NAME,UNIQUE_ID,PROJECT_TYPE) VALUES(USER_PROJECTS_SEQUENCE.nextval,?,?,?,?)");
			prSt = con.prepareStatement(sqlQuery);
			prSt.setString(1,createdBy );
			prSt.setString(2, pName);
			prSt.setString(3, uniqueId);
			prSt.setString(4, pType);
			
			prSt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			prSt.close();
			con.close();
		}
	
	}

}
