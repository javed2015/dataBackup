package com.zeptoh.lynk.controls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.zeptoh.lynk.service.URLServiceImpl;

/**
 * Servlet implementation class LynkedServlet
 */
@WebServlet("/LynkedURL")
public class LynkedURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private URLServiceImpl urlService = new URLServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LynkedURL() {
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
	//@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String myURL = request.getParameter("URL");
		response.setContentType("text/html; charset=UTF-8");
		  String lynk_context;
		  if (request.getServerName().contains("localhost")) {
		   lynk_context = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+request.getContextPath();  
		  } else {
		   lynk_context = request.getScheme()+"://"+ request.getServerName()/*+":"+request.getServerPort()+request.getContextPath()*/;
		  }
		ServletContext context=getServletContext();  
		context.setAttribute("lynk_context", lynk_context);
		String source = urlService.getResponse(myURL, "generate", null, lynk_context);
		PrintWriter out = response.getWriter();
		
		out.print(source);
	}
}