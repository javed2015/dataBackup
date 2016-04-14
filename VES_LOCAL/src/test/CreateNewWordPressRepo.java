package test;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CreateNewWordPressRepo {
	private static Git gitSecondary;
	private static UsernamePasswordCredentialsProvider upcp = null;
	static String localNewRepo;
	private static Repository localRemoRepo;
	
	public static void main(String []args){
		try {
			init();
			addChangesToNewRepo();
			commitChangesToNewRepo();
			pushChangesToNewRepo();
		} catch (JGitInternalException | IOException | GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void init(){
	try {
		localRemoRepo = new FileRepository("C:\\VOTSH\\TesJav" + "/.git");
		gitSecondary = new Git(localRemoRepo);
		upcp= new UsernamePasswordCredentialsProvider("javed2015",
				"Jcore1902Nett");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void addChangesToNewRepo() throws IOException, GitAPIException {
		gitSecondary.add().addFilepattern("content-template/").call();
		System.out.println("added");
	}

	public static void commitChangesToNewRepo() throws IOException, GitAPIException,
			JGitInternalException {
		gitSecondary.commit().setMessage("Added Source To New Repository")
				.call();
		System.out.println("commited");
	}

	public static void pushChangesToNewRepo() throws IOException,
			JGitInternalException, GitAPIException {
		gitSecondary.push().setRemote("https://github.com/javed2015/WordPressSample.git")
				.setCredentialsProvider(upcp).call();
		System.out.println("pushed");
	}

}
