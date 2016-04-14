package test;


import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CreateBranchCommand.SetupUpstreamMode;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CloneUsingSsh {

    private String localPath, remotePath;
    private Repository localRepo;
    private Git git;
    private static File index = new File("C:\\SshCloneTest\\testing");
   static // private UsernamePasswordCredentialsProvider upcp = new 
    String remoteUrl = new StringBuffer().append("https").append("javed1989")
            .append(":").append("Jzeptoh1902").append("@github.com/")
            .append("javed1989").append("/").append("v").toString();

    
    public static void main(String []args){
    	CloneUsingSsh cus = new CloneUsingSsh();
    	try {
//    		/https://github.com/frankcohen/v.git
    		//git@github.com:frankcohen/v.git
    		
    		org.eclipse.jgit.api.Git.cloneRepository().setURI(remoteUrl).setDirectory(index)
            .call();
    		
    		/*Git.cloneRepository()
    		  .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "javed1989", "Jzeptoh1902" ) )
    		  .setURI( "git@github.com:frankcohen/v.git" )
    		  .setDirectory( index )
    		  .setCloneAllBranches( true )
    		  .call();*/
    		/*cus.init();
			cus.testCreate();	
				cus.testClone();*/
    	}
			catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

  //  @Before
    public void init() throws IOException {
        localPath = "C:\\SshCloneTest\\testing";
        remotePath = "git@github.com:frankcohen/v.git";
        localRepo = new FileRepository(localPath + "/.git");
        git = new Git(localRepo);
    }

 //   @Test
    public void testCreate() throws IOException {
        Repository newRepo = new FileRepository(localPath + ".git");
        newRepo.create();
    }

  //  @Test
    public void testClone() throws IOException, GitAPIException {
        Git.cloneRepository().setURI(remotePath)
                .setDirectory(new File(localPath)).call();
    }

 //   @Test
    public void testAdd() throws IOException, GitAPIException {
        File myfile = new File(localPath + "/myfile");
        myfile.createNewFile();
        git.add().addFilepattern("myfile").call();
    }

 //   @Test
    public void testCommit() throws IOException, GitAPIException,
            JGitInternalException {
        git.commit().setMessage("Added myfile").call();
    }

 //   @Test
    public void testPush() throws IOException, JGitInternalException,
            GitAPIException {
        git.push().call();
    }

  //  @Test
    public void testTrackMaster() throws IOException, JGitInternalException,
            GitAPIException {
        git.branchCreate().setName("master")
                .setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM)
                .setStartPoint("origin/master").setForce(true).call();
    }

  //  @Test
    public void testPull() throws IOException, GitAPIException {
        git.pull().call();
    }
}
