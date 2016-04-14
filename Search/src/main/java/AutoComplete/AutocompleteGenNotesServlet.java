package AutoComplete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/agns")
public class AutocompleteGenNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		 PrintWriter out = response.getWriter();
		    out.write(AutoCompleteNotesResult.returnAutoCompleteQueryResult(query).toString());
		    out.flush();
	        out.close();
	}

}

