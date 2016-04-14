package test;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CreateNewRepository {
	
	

	private String remotePath;
	
	
	private String localPath;
	private Repository localRepo;
	private Git git;
	private UsernamePasswordCredentialsProvider upcp = null;
	private static File index;

	public void init() throws IOException {
		try {
			localPath = "C:\\VOTSH\\NewRepo";
			 index = new File("C:\\VOTSH");
			remotePath = "https://github.com/javed2015/TesJav.git";
			upcp = new UsernamePasswordCredentialsProvider("javed2015",
					"Jcore1902Nett");
			localRepo = new FileRepository(localPath + "/.git");

		//	git = new Git(localRepo);

		} catch (Exception e) {
			System.out.println("Exception in init");
			e.printStackTrace();
		}

	}
	
	public void createRepository(){
	
			Git git;
			try {
				git = Git.init().setDirectory(index).call();
				 System.out.println("Having repository: " + git.getRepository().getDirectory());
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
       
	}
	
	
	public static void main(String []args){
		CreateNewRepository cnr = new CreateNewRepository();
		try {
			cnr.init();
			cnr.createRepository();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 private static File createSampleGitRepo(){
	        Repository repository;
	        File dir = null;
			try {
				repository = CookBookHelper.createNewRepository();
				 System.out.println("Temporary repository at " + repository.getDirectory());

			        // create the file
			        File myfile = new File(repository.getDirectory().getParent(), "C:testfile");
			        myfile.createNewFile();

			        // run the add-call
			        new Git(repository).add()
			                .addFilepattern("testfile")
			                .call();


			        // and then commit the changes
			        new Git(repository).commit()
			                .setMessage("Added testfile")
			                .call();
			        
			        System.out.println("Added file " + myfile + " to repository at " + repository.getDirectory());
			        
			        dir = repository.getDirectory();
			        
			        repository.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoFilepatternException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	       
	        
	        return dir;
	    }
	
	
	/* public static void main(String[] args) throws IOException, GitAPIException {
	        // first create a test-repository, the return is including the .get directory here!
	        File repoDir = createSampleGitRepo();
	        
	        // now open the resulting repository with a FileRepositoryBuilder
	        FileRepositoryBuilder builder = new FileRepositoryBuilder();
	        Repository repository = builder.setGitDir(repoDir)
	                .readEnvironment() // scan environment GIT_* variables
	                .findGitDir() // scan up the file system tree
	                .build();

	        System.out.println("Having repository: " + repository.getDirectory());

	        // the Ref holds an ObjectId for any type of object (tree, commit, blob, tree)
	        Ref head = repository.getRef("refs/heads/master");
	        System.out.println("Ref of refs/heads/master: " + head);

	        repository.close();
	    }
	*/

	
}
