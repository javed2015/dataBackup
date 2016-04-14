package com.votsh.build;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.votsh.support.ConnectionProvider;

public class BuildUniqueId {
	
	public String uniqueId(String uId) throws SQLException{
		String status = "";
			String pCreator = uId;		
			Connection con=null;
			PreparedStatement ps=null;		
			ResultSet rs=null;	
			try {	
				con=ConnectionProvider.getConnection();	
				String primaryQuery = "select max(rownum)+1 countOn from new_projects where CREATED_BY =?";
				ps = con.prepareStatement(primaryQuery);
				ps.setString(1, pCreator);										
				rs = ps.executeQuery();	
				while(rs.next()){
					if(rs.next()){
					status=rs.getString("countOn");
					}else{
						status="1";
					}
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rs.close();
				ps.close();	
				con.close();
			}
			return status;
		}

}
