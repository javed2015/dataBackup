package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//import com.votsh.support.ConnectionProvider;

public class TestTimeEstimate {
	
	static Connection con;
	final static String username = "apc";
	final static String password = "apc";
	final static String driver = "com.mysql.jdbc.Driver";
	static String connectionStirng = null;
	String executionId = "";
	public TestTimeEstimate(String url,String exeId){
		connectionStirng = "jdbc:mysql://"+url+":3306/apc";
		executionId = exeId;		
	}
	
	
	public static Connection getConnection() throws ClassNotFoundException {
		try{
		
			Class.forName(driver);
		    con = DriverManager.getConnection(connectionStirng,username,password);			 
		}catch(SQLException e) {e.printStackTrace();}
		return con;
	}
	
	
	public String userDbFetch() throws SQLException, ClassNotFoundException{	
		con = TestTimeEstimate.getConnection();	
		PreparedStatement ps=null;
		double percentage = 0;
		String angleFormated ="";
		ArrayList<String> al = new ArrayList<String>();
		try {			
			String sqlQuery = "Select duration from steppertestcaseexecution where StepDefinitionId in ("
					+ "select StepDefinitionId from stepdefinition where TestCaseDefinitionId in ("
					+ "select TestCaseDefinitionId from testcaseexecution where ScenarioExecutionId=?))";		
			ps = con.prepareStatement(sqlQuery);
			 ps.setString(1, executionId);	    
		    	 ResultSet rs = ps.executeQuery();
			while(rs.next()){
				al.add(rs.getString("duration"));
			}
			System.out.println(al.size());
			Iterator<String> itr = al.iterator();
			
	
			
			 while(itr.hasNext()){
			String element = itr.next();
			if(element.startsWith("-")){
				itr.remove();
			}
			 }
			 
			 double calculatedTests = al.size();
			 System.out.println("calculatedTests size is :"+al.size());
			 Iterator<String> percentageItr = al.iterator(); 
			 while(percentageItr.hasNext()){
					int element = Integer.parseInt(percentageItr.next());							
					if(element>5000){
						percentageItr.remove();
					}				
					 }
			 System.out.println("testsPerfect size is :"+al.size());
			 double testsPerfect = al.size();
			 
			percentage =  ((testsPerfect/calculatedTests)*100);	
			DecimalFormat df = new DecimalFormat("#.00");
				 angleFormated = df.format(percentage);
			System.out.println("percentage is :"+angleFormated);
					rs.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			ps.close();		
			con.close();
		}
	
		return angleFormated;
	}
	
	
}


