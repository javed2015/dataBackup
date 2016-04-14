<%@ page import="java.sql.*"%>
<%@ page import="com.votsh.support.ConnectionProvider"%>

<%
	String F_Name = request.getParameter("fname");
	String L_Name = request.getParameter("lname");
	String U_Name = request.getParameter("email");
	String userid = (String) session.getAttribute("userid");
	Connection con;
	con = ConnectionProvider.getConnection();
	try {
		Statement st = con.createStatement();
		int ars = st.executeUpdate("update USER_DETAILS set F_NAME='"
				+ F_Name + "',L_NAME='" + L_Name + "',USER_NAME='"
				+ U_Name + "' where USER_NAME='" + userid + "'");
		if (ars > 0) {
			session.setAttribute("userid", U_Name);
			session.setAttribute("firstname", F_Name);
			session.setAttribute("lastname", L_Name);
			session.setAttribute("name", F_Name + " " + L_Name);
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