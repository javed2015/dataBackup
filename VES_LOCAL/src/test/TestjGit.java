package test;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class TestjGit {

    private String localPath,localRemorepo, remotePath,remoteSeconPath;
    private Repository localRepo;
    private Git gitPrimary, gitSecondary;
    private static File index;
    private UsernamePasswordCredentialsProvider upcp = null;
    
    
    public static void main(String []args){
    	TestjGit tjg = new TestjGit();
    	try {
			tjg.init();
			tjg.createLocalRepo();
			/*tjg.createRemoteRepo();
			tjg.cloneRepo();
			tjg.testPull();*/
		//	 tjg.testAdd();
				tjg.testCommit();
				tjg.testPush();
		} catch (JGitInternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   
    public void init() throws IOException, GitAPIException {
        localPath = "C:\\VOTSH\\VOTSH\\WordPress";
        localRemorepo = "C:\\VOTSH\\TesJav";
        index = new File(localPath);
        remotePath = "https://github.com/javed2015/TesJav.git";
        remoteSeconPath = "https://github.com/javed2015/"+"NewRepoTest"+".git";
        localRepo = new FileRepository(localRemorepo + "/.git");
        upcp = new UsernamePasswordCredentialsProvider("javed2015", "Jcore1902Nett");
        gitPrimary = new Git(localRepo);
        System.out.println("in init");
 //    git.
     //      git = Git.init().setDirectory(index).call();
    }

    public void createLocalRepo(){
    	
	//	Git git;
		try {
			gitSecondary = Git.init().setDirectory(index).call();
			 System.out.println("Having repository: " + gitSecondary.getRepository().getDirectory());
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
   
}
    
   
    
    public void createRemoteRepo(){
        GitHub github;
    	try {
    		github = GitHub.connectUsingPassword("javed2015", "Jcore1902Nett");
    		GHRepository repo = github.createRepository(
    				   "NewRepoTest","this is my new repository",
    				   "http://www.zeptoh.com/",true/*public*/);
    				
    		System.out.println("Create Remote Repo");
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	 
        }
    
    public void cloneRepo() throws IOException, GitAPIException {
  	  try {
  	   Git.cloneRepository().setURI(remotePath)
  	     .setDirectory(new File(localRemorepo)).call();
  	 System.out.println("Cloned");
  	  } catch (Exception e) {    	
  	   // TODO Auto-generated catch block
  	   e.printStackTrace();
  	  }
  	 }
    
    public void testPull() throws IOException, GitAPIException {
    	  try {
    	//	  gitPrimary = new Git(localRepo);
    		  gitPrimary.pull().setCredentialsProvider(upcp).call();
    	   System.out.println("pull");
    	  } catch (Exception e) {
    	   System.out.println("Exception in pull");
    	   e.printStackTrace();
    	  }
    	 }
    
    public void testAdd() throws IOException, GitAPIException {
    	 localPath = "C:\\VOTSH\\NewRepoTest";
    	  localRepo = new FileRepository(localPath + "/.git");
   //     File myfile = new File(localPath+"\\InstantWinApp");
    //    myfile.createNewFile();
    	
    	gitSecondary = new Git(localRepo);
        gitSecondary.add().addFilepattern(localPath+"\\InstantWinApp").call();
        System.out.println("added");
    }

    public void testCommit() throws IOException, GitAPIException,
            JGitInternalException {
    	 localPath = "C:\\VOTSH\\NewRepoTest";
   	  localRepo = new FileRepository(localPath + "/.git");
    	gitSecondary = new Git(localRepo);
    	gitSecondary.commit().setMessage("Added myfile").call();
    	System.out.println("commit");
    }

  
    public void testPush() throws IOException, JGitInternalException,
            GitAPIException {
    	   remoteSeconPath = "https://github.com/javed2015/"+"NewRepoTest"+".git";
    	   upcp = new UsernamePasswordCredentialsProvider("javed2015", "Jcore1902Nett");
    	gitSecondary.push().setRemote(remoteSeconPath).setCredentialsProvider(upcp).call();
    	System.out.println("push");
    }
   

  
}
