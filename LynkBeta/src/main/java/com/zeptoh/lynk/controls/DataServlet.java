package com.zeptoh.lynk.controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zeptoh.lynk.common.CommonDaoImpl;
import com.zeptoh.lynk.model.SelectedContent;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SecureRandom random = new SecureRandom();

	public static String nextSessionId() {
		return new BigInteger(130, random).toString(32);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. get received JSON data from request
		String userId = null;
		  Cookie[] cookies = request.getCookies();
		  if(cookies != null){
		   for(Cookie cookie : cookies){
		     if(cookie.getName().equals("userid")) {
		      userId = cookie.getValue();
		     }
		   }
		  }
		try {
			SelectedContent selContent = new SelectedContent();
			selContent.setData(request.getParameter("storedSelections"));
			selContent.setDescription(request.getParameter("lynk_desc"));
			selContent.setDummy1(request.getParameter("lynk_dummy1"));
			selContent.setDummy2(request.getParameter("lynk_dummy2"));
			selContent.setFlag(request.getParameter("lynk_flag"));
			selContent.setName(request.getParameter("lynk_name"));
			selContent.setToken(nextSessionId());
			selContent.setUrl(request.getParameter("lynk_url"));
			selContent.setUserId(userId);
//	System.out.println("user ID :"+selContent.getUserId());
			CommonDaoImpl documentDAO = new CommonDaoImpl();
			documentDAO.storeLynk(selContent);
			String token= selContent.getToken();
			PrintWriter pw = response.getWriter();
			pw.write(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}