package com.votsh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votsh.deleteProject.DeletingProject;

/**
 * Servlet implementation class DeleteProjectImpl
 */
@WebServlet("/DeleteProjectImpl")
public class DeleteProjectImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProjectImpl() {
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
		
		//For Deleting The Project
				String projCreator = request.getParameter("projectCreator");
				String projName = request.getParameter("projectName");
				String userId = request.getParameter("userid");
				if(projCreator.equalsIgnoreCase(userId)){
					try {
						DeletingProject dp = new DeletingProject();
						DeletingProject.getGitCredentials(userId);
						dp.deleteDataInTables(userId,projName);
						dp.deleteRemoteRepository(projName);
						dp.deleteJenkinsJob(projName);
					} catch (InterruptedException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PrintWriter delete = response.getWriter();
					response.setContentType("text/html");								
					delete.write("ProjectDeleted");	
					delete.flush();
					delete.close();
				}
	}

}
