package com.votsh.deleteProject;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import com.votsh.support.ConnectionProvider;

public class DeletingProject {

	private static String gitUsrName;
	private static String gitPwd;

	// Fetching Repository Credentials For The User
	public static void getGitCredentials(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement prSt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			String query = ("SELECT GITHUB_USERNAME,GITHUB_PASSWORD FROM USER_DETAILS where USER_NAME=?");
			prSt = con.prepareStatement(query);
			prSt.setString(1, userId);
			rs = prSt.executeQuery();
			while (rs.next()) {
				gitUsrName = rs.getString("GITHUB_USERNAME");
				gitPwd = rs.getString("GITHUB_PASSWORD");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rs.close();
			prSt.close();	
			con.close();
		}
	}

	// For Deleting Tables
	public void deleteDataInTables(String userId, String ProjName) throws SQLException {
		String uid = userId;
		String pName = ProjName;
		Connection con = null;
		CallableStatement calSt = null;
		try {
			con = ConnectionProvider.getConnection();
			calSt = con.prepareCall("{call SP_DELETE_VES_PROJ(?,?,?,?)}");
			calSt.setString(1, pName);
			calSt.setString(2, uid);
			calSt.registerOutParameter(3, Types.VARCHAR);
			calSt.registerOutParameter(4, Types.VARCHAR);
			calSt.executeUpdate();
			calSt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			calSt.close();
			con.close();
		}

	}

	// Deleting Remote Repository
	public void deleteRemoteRepository(String ProjName) {
		GitHub github;
		try {
			github = GitHub.connectUsingPassword(gitUsrName, gitPwd);
			GHRepository repo = github.getRepository(gitUsrName + "/"
					+ ProjName);
			repo.delete();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// For Deleting Jenkins Job
	public void deleteJenkinsJob(String ProjName) throws InterruptedException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://52.76.12.9:8082/job/"
				+ ProjName + "/doDelete");
		String content = "";
		httpPost.addHeader("content-type", "application/x-www-form-urlencoded");

		httpPost.setEntity(null);
		// Execute the HTTP Request

		try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity respEntity = response.getEntity();

			if (respEntity != null) {
				// EntityUtils to get the response content
				content = EntityUtils.toString(respEntity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
