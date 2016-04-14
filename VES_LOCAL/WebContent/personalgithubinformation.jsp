<%@ page import="java.sql.*"%>
<%@ page import="com.votsh.support.ConnectionProvider"%>

<%
	String GITHUB_USERNAME = request.getParameter("github-uname");
	String GITHUB_PASSWORD = request.getParameter("github-password");
	String userid = (String) session.getAttribute("userid");
	Connection con;
	con = ConnectionProvider.getConnection();
	try {
		Statement st = con.createStatement();
		int nrs = st
				.executeUpdate("update USER_DETAILS set GITHUB_USERNAME='"
						+ GITHUB_USERNAME
						+ "',GITHUB_PASSWORD='"
						+ GITHUB_PASSWORD
						+ "' where USER_NAME='"
						+ userid + "'");
		if (nrs > 0) {
			session.setAttribute("githubuname", GITHUB_USERNAME);
			session.setAttribute("githubpword", GITHUB_PASSWORD);
			response.sendRedirect("profile.jsp");
		} else {
			request.setAttribute("message", "Setting not updated");
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
			return;
		}
	} catch (SQLException e) {
		request.setAttribute("message", "Invalid User Name or Password");
		e.printStackTrace();
	} finally {
		con.close();
	}
%>