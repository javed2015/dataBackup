package com.votsh.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.votsh.support.ConnectionProvider;

public class NotificationList {

	DateFormat cbd = new SimpleDateFormat("dd/MMM/yy");
	Date date = new Date();

	public String projectRequest(String uId) throws SQLException {
		String status = "[";
		String finalNotification = "";
		String creator = uId;
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnectionProvider.getConnection();
			String primaryQuery = "SELECT ROWNUM,PA.USER_ID user_id,PA.PROJECT_NAME proj_Name,PA.ACCESS_APPROVE FROM VES_PROJ_APPROVE PA, NEW_PROJECTS NP "
					+ "WHERE PA.PROJECT_NAME=NP.PROJECT_NAME AND PA.REQUEST_ACCESS=1 AND PA.ACCESS_APPROVE=0 AND NP.CREATED_BY=?";
			ps = con.prepareStatement(primaryQuery);
			ps.setString(1, creator);
			rs = ps.executeQuery();

			String[] user_name = new String[1];
			String[] project_name = new String[1];			
			while (rs.next()) {
				user_name[0] = rs.getString("user_id");
				project_name[0] = rs.getString("proj_Name");
				status = status + "{\" data\": [\"" + user_name[0] + "\"" + ","
						+ "\"" + project_name[0] + "\"]},";
			}
			String notification = status.substring(0, status.length() - 1);
			finalNotification = notification + "]";		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			con.close();
		}

		return finalNotification;
	}

}
