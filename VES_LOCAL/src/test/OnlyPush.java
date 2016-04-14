package test;


import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class OnlyPush{

public static void main(String []args) throws IOException, JGitInternalException,GitAPIException {
	 UsernamePasswordCredentialsProvider upcp = null;
	  Git gitSecondary;
	  Repository localRepo;
	  
	  
	  String localPath = "/tmp/VOTSH/WordPressDefender_mohan@gmail.com";
	  localRepo = new FileRepository(localPath + "/.git");
		gitSecondary = new Git(localRepo);
	 upcp = new UsernamePasswordCredentialsProvider("javed2015", "Jcore1902Nett");
    	 String remoteSeconPath = "https://github.com/javed2015/LocalJavaTest.git";
    	//   upcp = new UsernamePasswordCredentialsProvider("javed2015", "Jcore1902Nett");
    	gitSecondary.push().setRemote(remoteSeconPath).setCredentialsProvider(upcp).call();
    	System.out.println("push");
    }
}