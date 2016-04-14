package com.votsh.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.votsh.support.ConnectionProvider;

public class ProjectAccessApproval {

	DateFormat cbd = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();

	public StringBuffer accessApprove(String uId, String reqBy, String projname,String reqval)
			throws SQLException {
		StringBuffer status = new StringBuffer();
		String pCreator = uId;
		String userId = reqBy;
		String pName = projname;
		String req=reqval;
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
			
			try {
				con = ConnectionProvider.getConnection();
				String primaryQuery = "SELECT * FROM NEW_PROJECTS WHERE "
						+ "CREATED_BY= ? AND PROJECT_NAME=?";
				ps = con.prepareStatement(primaryQuery);
				ps.setString(1, pCreator);
				ps.setString(2, pName);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (req.equals("1")){
					try {
						String sqlQuery = "UPDATE VES_PROJ_APPROVE SET ACCESS_APPROVE=1,APPROVED_DATE=? WHERE USER_ID=? AND PROJECT_NAME=?";
						pstmt = con.prepareStatement(sqlQuery);
						pstmt.setString(1, "");
						pstmt.setString(2, userId);
						pstmt.setString(3, pName);
						pstmt.executeUpdate();
						status.append("0");
						pstmt.close();
					}
					
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}else if(req.equals("0")){
						try {
							String sqlQuery = "DELETE FROM VES_PROJ_APPROVE where USER_ID =? AND PROJECT_NAME =? AND REQUEST_ACCESS = 1 AND ACCESS_APPROVE=0" ;
							pstmt = con.prepareStatement(sqlQuery);
							pstmt.setString(1, userId);
							pstmt.setString(2, pName);
							pstmt.executeUpdate();
							status.append("0");
							pstmt.close();
						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
		
		// System.out.println("status is:"+status);
		return status;
	}
	}


