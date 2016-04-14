package com.votsh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.json.JSONException;

import com.votsh.access.NewProjectDetails;
import com.votsh.build.NetClientPost;
import com.votsh.repository.CreateRepository;
import com.votsh.repository.LivingAppDetails;

/**
 * Servlet implementation class WordPressImpl
 */
@WebServlet("/WordPressImpl")
public class WordPressImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordPressImpl() {
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
		
		String repositorypath = request.getParameter("rpath");
		String projectname = request.getParameter("projname");
		String proj_type = request.getParameter("projecttype");
		String app = request.getParameter("platformval");
		String link = request.getParameter("cloudval");
		String language = request.getParameter("languageval");
		String uid = request.getParameter("userid");
		String status = request.getParameter("status");
		String githubUser = request.getParameter("githubUser");
		String githubPwd = request.getParameter("githubPass");
		
		NewProjectDetails npd = new NewProjectDetails();
		LivingAppDetails lad = new LivingAppDetails();
		NetClientPost ncp = new NetClientPost();
		
		//With No Parameters
		CreateRepository crNp = new CreateRepository();
		System.out.println("In wordpressimpl");
		
		try {
			 if (status.equals("0")) {
				PrintWriter aws2 = response.getWriter();
				response.setContentType("text/html");
				String remoUrl = lad.getGitUrl(proj_type);
			//	System.out.println("remoUrl"+remoUrl);
				CreateRepository cR = new CreateRepository(uid,githubUser,githubPwd,projectname,remoUrl,proj_type);
				
				cR.init();
				String Status = cR.createRemoteRepo();
			//	System.out.println("Status "+Status);
				if(Status.equalsIgnoreCase("Failure")){
					aws2.write("Invalid");
					status = "1";
					aws2.flush();
					aws2.close();
				}else{
				cR.clonePrimaryRepo();
				cR.pullPrimaryRepo();
				cR.checkOutPrimaryRepo();
				cR.pushChangesToNewRepo();				
				aws2.write("Updating To Database");
				status = "1";
				aws2.flush();
				aws2.close();
				}
			}else if (status.equals("1")) {
				PrintWriter aws1 = response.getWriter();
				response.setContentType("text/html");				
				aws1.write(npd.updateNewProject(uid, projectname,
						crNp.gitUrlPath(), proj_type, app, link, language));
				status = "2";
				aws1.flush();
				aws1.close();
			} /*else if (status.equals("2")) {
				PrintWriter fetch = response.getWriter();
				response.setContentType("text/html");
				fetch.write(ncp.buildJob(projectname,githubUser, githubPwd,crNp.remoteNewPath(),uid,proj_type));
				status = "3";
				fetch.flush();
				fetch.close();
			}else if (status.equals("3")) {
		//		System.out.println("in status 3");
				PrintWriter build = response.getWriter();
				response.setContentType("text/html");	
				String message = ncp.buildStatus(proj_type,proj_type);
				if(message.equalsIgnoreCase("success")){
				//	System.out.println("in if");
					build.write("Job Created");	
				}else{
				//	System.out.println("in else");
					build.write("Build Failed");
					request.setAttribute("status",
							"Build Failed");
					request.getRequestDispatcher("newprojectcreation.jsp").forward(request,
							response);
				}
				status = "4";
				build.flush();
				build.close();
			}
			else if (status.equals("4")) {
			//	System.out.println("in status 4");
				PrintWriter build = response.getWriter();
				response.setContentType("text/html");								
				ncp.buildJob(projectname);
				build.write("Build Initiated");	
				status = "5";
				build.flush();
				build.close();
			}else if (status.equals("5")) {
				PrintWriter build = response.getWriter();
				response.setContentType("text/html");	
				String message = ncp.buildStatus(projectname,proj_type);
				if(message.equalsIgnoreCase("success")){
					build.write("Job Created");	
				}else{
					build.write("Build Failed");
				}
				status = "6";
				build.flush();
				build.close();
			}else if (status.equals("6")) {
				PrintWriter build = response.getWriter();
				response.setContentType("text/html");	
				String message = ncp.buildStatus("DeployDefender",proj_type);
				if(message.equalsIgnoreCase("success")){
					build.write("Job Created");	
				}else{
					build.write("Build Failed");
				}
				status = "7";
				build.flush();
				build.close();
			}*/
			else {
				PrintWriter done = response.getWriter();
				response.setContentType("text/html");
				done.write("Terminate");
				done.flush();
				done.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
