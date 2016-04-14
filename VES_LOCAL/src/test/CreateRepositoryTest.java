package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;


import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class CreateRepositoryTest {

	private String localNewPath, localRemoPath,
	remotePath="https://github.com/javed2015/TesJav.git", 
	remoteNewPath, projectName="Instant",
	userName="javed2015", passWord="Jcore1902Nett", userId="javed@gmail.com";
	private Repository localRemoRepo, localNewRepo;
	private Git gitPrimary, gitSecondary;
	private static File index, delDir;
	private UsernamePasswordCredentialsProvider upcp = null;
	
	
	/*public CreateRepository(String uid,String uName, String pWd, String pName, String remPath ){
		
		this.userId=uid;
		this.userName=uName;
		this.passWord=pWd;
		this.projectName=pName;
		this.remotePath=remPath;
		
	}
*/
	public static void main(String[] args) throws InterruptedException {
		CreateRepositoryTest cR = new CreateRepositoryTest();
		try {
		cR.deleteRemoteRepo();
	//	cR.deleteJob();
			/*cR.init();
			cR.createLocalRepo();
			cR.createRemoteRepo();
			cR.clonePrimaryRepo();
			cR.pullPrimaryRepo();
			cR.checkOutPrimaryRepo();
			cR.moveSourceToNewRepo();
			cR.addChangesToNewRepo();
			cR.commitChangesToNewRepo();
			cR.pushChangesToNewRepo();*/
		} catch (JGitInternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void init() throws IOException, GitAPIException {
		localNewPath = "C:\\VOTSH\\"+projectName;
		localRemoPath = "C:\\VOTSH\\TesJav";
		index = new File(localNewPath);
		String[] rPath = remotePath.split("/");
		String basePath = rPath[0]+"//"+rPath[1]+rPath[2]+"/"+rPath[3]+"/";
		remoteNewPath = basePath + projectName
				+ ".git";
		localRemoRepo = new FileRepository(localRemoPath + "/.git");
		localNewRepo = new FileRepository(localNewPath + "/.git");
		/*localRemoRepo = new FileRepository("/tmp/VOTSH/TesJav/.git");
		localNewRepo = new FileRepository("/tmp/VOTSH/"+"projectName"+ "/.git");*/
		
		upcp = new UsernamePasswordCredentialsProvider(userName,
				passWord);
		gitPrimary = new Git(localRemoRepo);
		gitSecondary = new Git(localNewRepo);
		System.out.println("in init");
	}

	public void createLocalRepo() {
		try {
			Git git = Git.init().setDirectory(index).call();
			System.out.println("Having repository: "
					+ git.getRepository().getDirectory());
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createRemoteRepo() {
		GitHub github;
		try {
			github = GitHub.connectUsingPassword(userName, passWord);
			GHRepository repo = github
					.createRepository(projectName, "Created By"
							+" "+ userId,
							" ", true/* public */);

			System.out.println("Create Remote Repo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteRemoteRepo() {
		GitHub github;
		try {
			github = GitHub.connectUsingPassword("javed2015", "Jcore1902Nett");
			GHRepository repo = github
					.getRepository("javed2015/Instant");
			repo.delete();

			System.out.println("Deleted Remote Repo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteJob() throws InterruptedException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://52.76.12.9:8082/job/"+"Kalli"+"/doDelete");
		String content = "";
		httpPost.addHeader("content-type", "application/x-www-form-urlencoded");
		
		httpPost.setEntity(null);
		// Execute the HTTP Request
		 
		try {
		    HttpResponse response = httpClient.execute(httpPost);
		    HttpEntity respEntity = response.getEntity();

		    if (respEntity != null) {
		        // EntityUtils to get the response content
		        content =  EntityUtils.toString(respEntity);
		    }
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
      
      
	}
	
	

	public void clonePrimaryRepo() throws IOException, GitAPIException {
		try {
			Git.cloneRepository().setURI(remotePath)
					.setDirectory(new File(localRemoPath)).call();
			System.out.println("Cloned");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pullPrimaryRepo() throws IOException, GitAPIException {
		try {
			gitPrimary.pull().setCredentialsProvider(upcp).call();
			System.out.println("pull");
		} catch (Exception e) {
			System.out.println("Exception in pull");
			e.printStackTrace();
		}
	}

	public void checkOutPrimaryRepo() throws IOException, GitAPIException {
		try {
			gitPrimary.checkout().setAllPaths(true).call();
		} catch (Exception e) {
			System.out.println("exception checkout :");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void moveSourceToNewRepo() {
		try {
			delDir = new File(localNewPath + "\\InstantWinApp");
			FileDeleteStrategy.FORCE.delete(delDir);
			System.out.println("deleted");
		} catch (Exception e) {
		}

		File file = new File(localRemoPath + "\\InstantWinApp");
		File dir = new File(localNewPath);
		boolean success = file.renameTo(new File(dir, file.getName()));
		if (success) {
			System.out.println("File was successfully moved.\n");
		} else {
			System.out.println("File was not successfully moved.\n");
		}
	}

	public void addChangesToNewRepo() throws IOException, GitAPIException {
		gitSecondary.add().addFilepattern("InstantWinApp/").call();
		System.out.println("added");
	}

	public void commitChangesToNewRepo() throws IOException, GitAPIException,
			JGitInternalException {
		gitSecondary.commit().setMessage("Added Source To New Repository")
				.call();
		System.out.println("commited");
	}

	public void pushChangesToNewRepo() throws IOException,
			JGitInternalException, GitAPIException {
		gitSecondary.push().setRemote(remoteNewPath)
				.setCredentialsProvider(upcp).call();
		System.out.println("pushed");
	}

}
