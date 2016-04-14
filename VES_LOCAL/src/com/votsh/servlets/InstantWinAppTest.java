package com.votsh.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appvance.testing.AppvanceRunner;
import com.appvance.testing.TestTimeEstimate;

/**
 * Servlet implementation class InstantWinAppTest
 */
@WebServlet("/InstantWinAppTest")
public class InstantWinAppTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstantWinAppTest() {
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
		String url = request.getParameter("testurl");
		AppvanceRunner ar = new AppvanceRunner();
		try {
			String result = ar.mainTest(url);

			String[] exeId = result.split("exeId=");
			String[] machineUrl = result.split("//");
			String[] finalUrl = machineUrl[1].split(":8080");
			TestTimeEstimate tte = new TestTimeEstimate(finalUrl[0], exeId[1]);
			String percentage = tte.userDbFetch();
			String json = "[{ \"message\":\"" + result
					+ "\"},{\"percentage\":\"" + percentage + "\"}]";
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			System.out.println("json servlet :" + json);
			out.write(json.toString());
			out.flush();
			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
