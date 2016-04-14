package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxResponse
 */
@WebServlet("/AjaxResponse")
public class AjaxResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxResponse() {
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
		System.out.println("in ajax response");
		String status = request.getParameter("status");
		System.out.println(status);
	AjaxTestCall atc = new AjaxTestCall();
	 PrintWriter out=response.getWriter();
	//	int status = 0;
			if(status.equals("0")){
				 response.setContentType("text/html");
					//    System.out.println("json servlet :"+json); 
					    out.write(atc.add());
					    status = "1";
					    out.flush();
					    out.close();	
			}else if(status.equals("1")){
				 PrintWriter in=response.getWriter();
				    response.setContentType("text/html");
				    in.write(atc.multiply());
				    status = "2";
				    in.flush();
				    in.close();
			}else if(status.equals("2")){				   
				    PrintWriter done=response.getWriter();
				    response.setContentType("text/html");
				    done.write(atc.sub());
				    status="terminate";
				    done.flush();
				   done.close();
			}else if(status.equalsIgnoreCase("terminate")){				   
			    PrintWriter done=response.getWriter();
			    response.setContentType("text/html");
			    done.write("Terminate");			  
			    done.flush();
			   done.close();
		}
	}

}
