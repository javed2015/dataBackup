package com.votsh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votsh.dashboard.NewLivingApp;
/**
 * Servlet implementation class NewApp
 */
@WebServlet("/NewApp")
public class NewLivingAppImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewLivingAppImpl() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uName = request.getParameter("uName");
		String nameOfType = request.getParameter("name_of_the_type");
		String gitUrl = request.getParameter("gurl");
		String machineName = request.getParameter("mname");
		NewLivingApp nlp = new NewLivingApp();
		try { 
				PrintWriter new1 = response.getWriter();
				response.setContentType("text/html");				
				new1.write(nlp.updateNewLivingApp(uName,nameOfType,
						gitUrl, machineName));				
				new1.flush();
				new1.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


