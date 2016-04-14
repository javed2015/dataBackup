package com.votsh.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.votsh.support.ConnectionProvider;

public class DashBoardProjects {

	public String projects(String userID) throws SQLException {
		String dataSample = "";
		String user = userID;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnectionProvider.getConnection();
			String sqlQuery = "SELECT DISTINCT A.PROJECT_NAME pname, A.CREATED_BY uname, A.PROJECT_TYPE ptype, B.REQUEST_ACCESS req_access,"
					+ " B.ACCESS_APPROVE access_appr FROM NEW_PROJECTS A LEFT JOIN VES_PROJ_APPROVE B ON A.PROJECT_NAME=B.PROJECT_NAME "
					+ "AND B.USER_ID= ?";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();

			String[] user_name = new String[1];
			String[] project_name = new String[1];
			String[] project_type = new String[1];

			String[] status = new String[1];
			int rows = 0;
			int rownum = 101;
			dataSample = "[";

			while (rs.next()) {
				user_name[0] = rs.getString("uname");
				project_name[0] = rs.getString("pname");
				project_type[0] = rs.getString("ptype");
				if ((rs.getString("req_access") == null)
						&& (rs.getString("access_appr") == null)) {
					status[0] = "Request To Access";
				} else if ((rs.getInt("req_access") == 1)
						&& (rs.getInt("access_appr") == 0)) {
					status[0] = "Request Pending";
				} else if ((rs.getInt("req_access") == 1)
						&& (rs.getInt("access_appr") == 1)) {
					status[0] = "Access Allowed";
				}
				int count = ++rows;
				int rowCount = rownum++;
				dataSample = dataSample + "{ \"id\":" + count + ", \"data\": ["
						+ '"' + rowCount + '"' + ", " + '"' + user_name[0]
						+ '"' + ", " + '"' + project_name[0] + '"' + ", " + '"'
						+ status[0] + '"' + ", " + '"' + project_type[0] + '"'
						+ "]},";
			}
			dataSample = dataSample.substring(0, dataSample.length() - 1);
			dataSample += "]";
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
		return dataSample;
	}

}
