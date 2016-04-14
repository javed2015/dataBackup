package com.zeptoh.lynk.controls;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.zeptoh.lynk.dao.PasswordHashing;
import com.zeptoh.lynk.model.UserRegistration;
import com.zeptoh.lynk.service.UserRegistrationServiceImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/urs")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
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
		String uName = request.getParameter("user_reg_email");
		String pwd = request.getParameter("user_reg_pwd");
		String cnPwd = request.getParameter("user_reg_cnfrm_pwd");
		
		
		Cookie messageCk = null;
	//	HttpSession session = request.getSession(true);
		try {
		if(pwd.equals(cnPwd)){
		UserRegistrationServiceImpl ursi = new UserRegistrationServiceImpl();
		if(ursi.userAvailability(uName)){
			messageCk =new Cookie("message", "User Already Exists");
			response.addCookie(messageCk);
		//	 session.setAttribute("message","User Already Exists");
			 response.sendRedirect("index.jsp");
			 return;
		//	request.getRequestDispatcher("index.jsp").forward(request,response);
					
		}else{
			String salt = PasswordHashing.getSalt();
			
			
			UserRegistration ur = new UserRegistration();
			ur.setFirstName(request.getParameter("lynked_first_name"));
			ur.setLastName(request.getParameter("lynked_last_name"));
			ur.setPassword(salt+":"+PasswordHashing.get_SHA_1_SecurePassword(pwd,salt));
			ur.setUserId(uName);
			ur.setFlag("True");
			
			ursi.storeUserDetails(ur);
			
			
			/*session.setMaxInactiveInterval(200*60);
			  session.setAttribute("userid", ur.getUserId()); 
			  session.setAttribute("fName", ur.getFirstName()); 
			  session.setAttribute("lName", ur.getLastName());*/
			  
			  Cookie userCk =new Cookie("userid", ur.getUserId());
				Cookie fNameCk =new Cookie("fName", ur.getFirstName());
				response.addCookie(userCk);
				response.addCookie(fNameCk);
				messageCk =new Cookie("message", "You have Successfully Registered and Logged In");
				response.addCookie(messageCk);
			 /*session.setAttribute("message",
					"You have Successfully Registered and Logged In");*/
			 response.sendRedirect("index.jsp");
			 return;
		//	request.getRequestDispatcher("index.jsp").forward(request,response);
					
		}
		}else{	
			messageCk =new Cookie("message", "Passwords are not matching");
			response.addCookie(messageCk);
			 /*session.setAttribute("message",
					"Passwords are not matching");*/
			 response.sendRedirect("index.jsp");
			 return;
		//	request.getRequestDispatcher("index.jsp").forward(request,response);
					
		}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("index.jsp");
			return;
	//	request.getRequestDispatcher("index.jsp").forward(request,response);
					
		}
	}

}
