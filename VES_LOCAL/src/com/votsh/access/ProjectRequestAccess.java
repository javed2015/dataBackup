package com.votsh.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.votsh.support.ConnectionProvider;

public class ProjectRequestAccess {

	DateFormat cbd = new SimpleDateFormat("dd/MMM/yy");
	Date date = new Date();

	public String projectRequest(String uId, String projname, String projType,
			String projCreator, String access) throws SQLException {
		String status = access;
		String userId = uId;
		String pName = projname;
		String ptype = projType;
		String pCreator = projCreator;

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (status == "") {
			try {
				con = ConnectionProvider.getConnection();
				String primaryQuery = "SELECT * FROM NEW_PROJECTS WHERE "
						+ "CREATED_BY= ? AND PROJECT_NAME=? AND PROJECT_TYPE=?";
				ps = con.prepareStatement(primaryQuery);
				ps.setString(1, pCreator);
				ps.setString(2, pName);
				ps.setString(3, ptype);
				rs = ps.executeQuery();
				while (rs.next()) {

					try {
						String sqlQuery = "INSERT INTO VES_PROJ_APPROVE (USER_ID,PROJECT_NAME,REQUEST_ACCESS,ACCESS_APPROVE,REQUESTED_DATE)"
								+ "VALUES (?,?,?,?,?)";
						pstmt = con.prepareStatement(sqlQuery);
						pstmt.setString(1, userId);
						pstmt.setString(2, pName);
						pstmt.setString(3, "1");
						pstmt.setString(4, "0");
						pstmt.setString(5, cbd.format(date));
						pstmt.executeUpdate();
						status = "0";
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						pstmt.close();
					}
				}

				
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
		}
		return status;
	}

}
