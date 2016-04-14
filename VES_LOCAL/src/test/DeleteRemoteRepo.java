package test;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class DeleteRemoteRepo {
	
	public static void main(String []args){
	
			GitHub github;
			try {
				github = GitHub.connectUsingPassword("javed2015", "Jcore1902Nett");
				GHRepository repo = github.getRepository("javed2015" + "/"
						+ "InsWinner");
				repo.delete();
System.out.println("des");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
