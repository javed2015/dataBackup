<%@ page import="java.sql.*"%>
<%@ page import="com.votsh.support.ConnectionProvider"%>

<%
	String userid = request.getParameter("uname");
	String pwd = request.getParameter("pass");
	Connection con = null;
	con = ConnectionProvider.getConnection();
	try {
		Statement st = con.createStatement();
		ResultSet rs;
		rs = st.executeQuery("select * from USER_DETAILS where USER_NAME='"
				+ userid + "' and PASSWORD='" + pwd + "'");
		if (rs.next()) {
			session.setAttribute("userid", userid);
			session.setAttribute("firstname", rs.getString(4));
			session.setAttribute("lastname", rs.getString(5));
			session.setAttribute("name",
					rs.getString(4) + " " + rs.getString(5));
			session.setAttribute("password", rs.getString(3));
			session.setAttribute("githubuname", rs.getString(8));
			session.setAttribute("githubpword", rs.getString(9));
			response.sendRedirect("dashboard.jsp");

		} else {
			request.setAttribute("message",
					"Invalid User Name or Password");
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
			return;
		}
	} catch (SQLException e) {

		e.printStackTrace();
	} finally {
		con.close();
	}
%>
