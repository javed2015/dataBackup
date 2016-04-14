package com.votsh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votsh.access.ProjectAccessApproval;
import com.votsh.access.ProjectRequestAccess;

/**
 * Servlet implementation class DashBoard
 */
@WebServlet("/DashBoard")
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uid = request.getParameter("userId");// user id from session
		String pName = request.getParameter("projName");
		String pType = request.getParameter("projType");
		String pCreator = request.getParameter("projCreator");
		String access = request.getParameter("access");

		String validNo = request.getParameter("validNo");
		String reqUser = request.getParameter("reqUser");
		String project = request.getParameter("project");

		ProjectRequestAccess dbpa = new ProjectRequestAccess();
		ProjectAccessApproval paa = new ProjectAccessApproval();

		try {
			if (pCreator != null) {
				response.setContentType("text/html");
				// Request Access
				String result = dbpa.projectRequest(uid, pName, pType,
						pCreator, access).toString();
				String json = "[{ \"message\":\"" + result + "\"}]";
				PrintWriter reqAccess = response.getWriter();
				reqAccess.write(json.toString());
				reqAccess.flush();
				reqAccess.close();
			} else {
				response.setContentType("text/html");
				// Access Approval
				StringBuffer status = new StringBuffer(paa.accessApprove(uid,
						reqUser, project, validNo));
				String jsonFormat = "[{ \"message\":\"" + status + "\"}]";
				PrintWriter accessApprove = response.getWriter();
				accessApprove.write(jsonFormat.toString());
				accessApprove.flush();
				accessApprove.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
