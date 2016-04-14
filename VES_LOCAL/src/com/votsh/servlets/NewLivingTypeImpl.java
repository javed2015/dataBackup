package com.votsh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.votsh.support.ConnectionProvider;


/**
 * Servlet implementation class DashBoard
 */
@WebServlet("/NewLivingType")
public class NewLivingTypeImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewLivingTypeImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
//		String sample = "";
//		JSONObject jsonObject = new JSONObject();
		JSONArray NewLivingTypeJsonArray = new JSONArray();  
		try {
			con = ConnectionProvider.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT NAME_OF_THE_TYPE FROM  VES_LIVING_APP");
				while (rs.next()) {
				JSONObject NewLivingTypeObject = new JSONObject();
				NewLivingTypeObject.put("nameOfType", rs.getString(1));
				NewLivingTypeJsonArray.put(NewLivingTypeObject);
			}
			rs.close();
			st.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PrintWriter done = response.getWriter();
	    response.setContentType("text/html");
	    done.write(NewLivingTypeJsonArray.toString());
	    done.flush();
	    done.close();
	}	
	}


