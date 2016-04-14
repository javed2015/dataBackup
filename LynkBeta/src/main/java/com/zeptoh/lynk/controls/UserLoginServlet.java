package com.zeptoh.lynk.controls;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zeptoh.lynk.model.UserRegistration;
import com.zeptoh.lynk.service.UserLoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/uls")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		Cookie messageCk = null;
	//	HttpSession session = request.getSession(true);
		try {
			String uName = request.getParameter("factual_email");
			String pwd = request.getParameter("factual_pwd");
			UserLoginServiceImpl ulsi = new UserLoginServiceImpl();
			UserRegistration ur = ulsi.getUserLogin(uName,pwd);
			
		//	session.setMaxInactiveInterval(200*60);
			
			Cookie userCk =new Cookie("userid", ur.getUserId());
			Cookie fNameCk =new Cookie("fName", ur.getFirstName());
			response.addCookie(userCk);
			response.addCookie(fNameCk);

		//	session.setAttribute("userid", ur.getUserId()); 
		//	  session.setAttribute("fName", ur.getFirstName()); 
		//	  session.setAttribute("lName", ur.getLastName());
			
			String userid = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
			for(Cookie cookie : cookies){
			 if(cookie.getName().equals("userid")) userid = cookie.getValue();
			}
			}
		//	if((session.getAttribute("userid")) != " "){
			if(userid != " "){
			response.sendRedirect("index.jsp");
			return;
		//	request.getRequestDispatcher("index.jsp").forward(request,response);
					
			}
			 else {
				messageCk =new Cookie("message", "Invalid User Name or Password");
				response.addCookie(messageCk);
				// session.setAttribute("message","Invalid User Name or Password");
				 response.sendRedirect("index.jsp");
				//	request.getRequestDispatcher("index.jsp").forward(request,response);
					return;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			messageCk =new Cookie("message", "Invalid User Name or Password");
			response.addCookie(messageCk);
			//session.setAttribute("message","Invalid User Name or Password");
			response.sendRedirect("index.jsp");
			return;
		//	request.getRequestDispatcher("index.jsp").forward(request,response);
					
		}
	}

}

