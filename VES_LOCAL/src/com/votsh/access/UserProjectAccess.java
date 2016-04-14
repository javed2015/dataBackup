package com.votsh.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.votsh.support.ConnectionProvider;

public class UserProjectAccess {

	public String userProjectAccess() throws SQLException {
		Connection con = null;
		Statement st = null;
		String dataSample = "null";
		try {
			con = ConnectionProvider.getConnection();
			String sqlQuery = "SELECT DP.SL_NO slno,DP.USER_NAME uname,DECODE(DP.PROJECT_NAME,'1','WINAPP','2','WORDPRESS','3','PEPSICO','4','COMMON') PROJ_NAME,"
					+ "DP.ACCESS_ALLOWED acc_allwd  FROM VES_DEMO_PROJECTS DP, USER_DETAILS UD WHERE DP.USER_NAME=UD.USER_NAME";
			st = con.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery(sqlQuery);
			String[] user_name = new String[1];
			String[] project_name = new String[1];
			String[] access_allowed = new String[1];
			String[] sl_no = new String[1];
			int rows = 0;
			int rownum = 101;
			while (rs.next()) {
				user_name[0] = rs.getString("uname");
				project_name[0] = rs.getString("PROJ_NAME");
				access_allowed[0] = rs.getString("acc_allwd");
				sl_no[0] = rs.getString("slno");
				int count = ++rows;
				int rowCount = rownum++;
				dataSample = dataSample + "{ id:" + count + ", data: [" + '"'
						+ rowCount + '"' + ", " + '"' + user_name[0] + '"'
						+ ", " + '"' + project_name[0] + '"' + ", " + '"'
						+ access_allowed[0] + '"' + "]},";
			}
			if (dataSample.endsWith(",")) {
				dataSample = dataSample.substring(0, dataSample.length() - 1)
						+ "]}";
			}
			if (dataSample.startsWith("null")) {
				dataSample = "{rows:["
						+ dataSample.substring(4, dataSample.length());
			}
			rs.close();
			st.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
		return dataSample;
	}
}
