
package AutoComplete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;


/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/srs")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		 DummyDB db = new DummyDB();
		 PrintWriter out = response.getWriter();
		    String query = request.getParameter("q");
		    JSONArray countries = db.getData(query);
		    out.write(countries.toString());
		    out.flush();
	        out.close();
	}

}
