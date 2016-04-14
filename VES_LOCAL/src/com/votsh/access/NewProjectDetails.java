package com.votsh.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.votsh.support.ConnectionProvider;

public class NewProjectDetails {

	public String updateNewProject(String userid, String projname,
			String repoPath, String proj_type, String appl, String lnk,
			String lang) throws SQLException {

		String status = "Creating Repository";
		DateFormat cbd = new SimpleDateFormat("dd/MMM/yy");
		Date date = new Date();
		Connection con = null;
		PreparedStatement prSt = null;
		try {
			try {
				con = ConnectionProvider.getConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {

				String query = ("insert into NEW_PROJECTS (CREATED_BY,PROJECT_NAME,REPOSITORY_PATH,PROJECT_TYPE,PLATFORM,CLOUD,LANGUAGE,CREATED_DATE) VALUES (?,?,?,?,?,?,?,?)");
				prSt = con.prepareStatement(query);
				prSt.setString(1, userid);
				prSt.setString(2, projname);
				prSt.setString(3, repoPath);
				prSt.setString(4, proj_type);
				prSt.setString(5, appl);
				prSt.setString(6, lnk);
				prSt.setString(7, lang);
				prSt.setString(8, cbd.format(date));
				prSt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				prSt.close();
			}
			try {

				String sqlQuery = ("insert into VES_PROJ_APPROVE (PROJECT_NAME,USER_ID,REQUEST_ACCESS,ACCESS_APPROVE,REQUESTED_DATE,APPROVED_DATE) VALUES(?,?,?,?,?,?)");
				prSt = con.prepareStatement(sqlQuery);
				prSt.setString(1, projname);
				prSt.setString(2, userid);
				prSt.setString(3, "1");
				prSt.setString(4, "1");
				prSt.setString(5, cbd.format(date));
				prSt.setString(6, cbd.format(date));
				prSt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				prSt.close();
				con.close();
			}
		} finally {
			prSt.close();
		}
		return status;
	}
}
