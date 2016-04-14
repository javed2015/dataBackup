package com.zeptoh.lynk.controls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zeptoh.lynk.dao.UserGeneratedNotesList;

/**
 * Servlet implementation class GeneratedNotesList
 */
@WebServlet("/gnl")
public class GeneratedNotesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratedNotesList() {
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
		
		String userId = null;
		  Cookie[] cookies = request.getCookies();
		  if(cookies != null){
		   for(Cookie cookie : cookies){
		     if(cookie.getName().equals("userid")) {
		      userId = cookie.getValue();
		     }
		   }
		  }
		  UserGeneratedNotesList ugnl = new UserGeneratedNotesList();
		  ugnl.getUserGeneratedNotes(userId);
		  String jsonData = ugnl.getUserGeneratedNotes(userId).toString();
		  PrintWriter pw = response.getWriter();
		  pw.write(jsonData);
		  pw.flush();
		  pw.close();
	}

}
