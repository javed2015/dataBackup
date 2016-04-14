package com.votsh.build;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.votsh.support.ConnectionProvider;
public class BuildTab {
	
	public String buildTask(String userId, String jobName) throws SQLException, JSONException{
		
		Connection con=null;
		String buildTask = "";
		String uId = userId;
		String jobN = jobName;
		JSONArray buildJsonArray = new JSONArray();
		try {
			con = ConnectionProvider.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
		//	Statement st = con.createStatement();
			String sqlQuery = "SELECT * FROM (SELECT USERID, JOB, BUILDNO, STATUS, LOG FROM USERBUILD WHERE USERID ='"+uId+"' "
					+ "AND JOB='"+jobN+"' ORDER BY BUILDNO DESC) jobname WHERE rownum <= 3 ORDER BY rownum asc";
			ps = con.prepareStatement(sqlQuery);
			/*ps.setString(1, uId);
			ps.setString(2, jobN);*/
			rs = ps.executeQuery();
			
			while (rs.next()) {
				JSONObject buildObject = new JSONObject();
				buildObject.put("userId", rs.getString(1));
				buildObject.put("job", rs.getString(2));
				buildObject.put("buildNo", rs.getString(3));
				buildObject.put("status", rs.getString(4));
				buildObject.put("log", rs.getString(5));
			
				buildJsonArray.put(buildObject);
			}
			buildTask = buildJsonArray.toString();
			rs.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
				con.close();
		}
		return buildTask;
	}
}


