package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.votsh.support.ConnectionProvider;

public class UniqueIdTest {
	
	public static void main(String []args) throws SQLException{
		String status = "";
			String pCreator = "mohan1@gmail.com";		
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
					System.out.println("pCreator--"+pCreator);
					System.out.println("rs.getString(countOn)"+rs.getString("countOn")+" "+pCreator);
					
					if(rs.getString("countOn")!=null){
					status=rs.getString("countOn");
					}else{
						status="1";
					}
				}
				
				rs.close();
				ps.close();	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con.close();
			}
		
		System.out.println("userProject count is:"+status);
		//	return status;
		}


}
