package com.zeptoh.lynk.controls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zeptoh.lynk.common.CommonDaoImpl;

/**
 * Servlet implementation class RetrieveServlet
 */
@WebServlet("/RetrieveServlet")
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CommonDaoImpl documentDAO = new CommonDaoImpl();
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		try {
			String data = " " ;//documentDAO.retrieveLynk("","lynked");
			pw.write(data);
		}catch(NullPointerException ne) {
			pw.write(" ");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
