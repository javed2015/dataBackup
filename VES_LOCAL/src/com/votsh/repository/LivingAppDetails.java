package com.votsh.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.votsh.support.ConnectionProvider;

public class LivingAppDetails {
	private String jobType;
	private String gitUrl;
	private String machine_name;
	
	public String getGitUrl(String proj_type)throws SQLException {
		String gitUrl="";
		Connection con = null;
		PreparedStatement prSt = null;
		ResultSet rs =null;
		try {
			con = ConnectionProvider.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			String query = ("SELECT NAME_OF_THE_TYPE,GITHUB_URL,MACHINE_NAME from VES_LIVING_APP where NAME_OF_THE_TYPE=?");  
			prSt = con.prepareStatement(query);
			prSt.setString(1, proj_type);
		//	System.out.println(query);
			rs = prSt.executeQuery();
			while(rs.next()){
				gitUrl = rs.getString("GITHUB_URL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs.close();
			prSt.close();
			con.close();
		}
		return gitUrl;
	}
	
	public String getMachineName(String proj_type)throws SQLException {
			String machine_name="";
			Connection con = null;
			PreparedStatement prSt = null;
			try {
				con = ConnectionProvider.getConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {

				String query = ("SELECT NAME_OF_THE_TYPE,GITHUB_URL,MACHINE_NAME from VES_LIVING_APP where USER_NAME=?");  
				prSt = con.prepareStatement(query);
				prSt.setString(1, proj_type);
				System.out.println(query);
				ResultSet rs = prSt.executeQuery();
				while(rs.next()){
					machine_name = rs.getString("MACHINE_NAME");				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				prSt.close();
				con.close();
			}
			return machine_name;
		}
	
	public String getJobType(String proj_type)throws SQLException {
			String jobType="";
			Connection con = null;
			PreparedStatement prSt = null;
			try {
				con = ConnectionProvider.getConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {

				String query = ("SELECT NAME_OF_THE_TYPE,GITHUB_URL,MACHINE_NAME from VES_LIVING_APP where USER_NAME=?");  
				prSt = con.prepareStatement(query);
				prSt.setString(1, proj_type);
				System.out.println(query);
				ResultSet rs = prSt.executeQuery();
				while(rs.next()){
					jobType = rs.getString("NAME_OF_THE_TYPE");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				prSt.close();
				con.close();
			}
			return jobType;
		}
	

}
