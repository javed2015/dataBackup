package com.votsh.repository;

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

public class CreateRepository {

	private static String project_Type, localRemoPath, remotePath, remoteNewPath, projectName, gitUName, GitPsWrd, userId;
	private Repository localRemoRepo;
	private Git gitPrimary;
	private UsernamePasswordCredentialsProvider upcp = null;

	
	
	public CreateRepository(String uid,String GituName, String gitPWd, String pName, String remPath,String proj_type ){
		userId=uid;
		gitUName=GituName;
		GitPsWrd=gitPWd;
		projectName=pName;
		remotePath=remPath;
		project_Type=proj_type;
	}
	
	public CreateRepository(){
		
	}


	public void init() throws IOException, GitAPIException {
		localRemoPath = "C:\\VOTSH\\"+project_Type+"_"+userId;
		String[] rPath = remotePath.split("/");
		String basePath = rPath[0]+"//"+rPath[1]+rPath[2]+"/"+rPath[3]+"/";
		remoteNewPath = basePath + projectName
				+ ".git";
		localRemoRepo = new FileRepository(localRemoPath + "/.git");
		upcp = new UsernamePasswordCredentialsProvider(gitUName,
				GitPsWrd);
		gitPrimary = new Git(localRemoRepo);
	}

	public String createRemoteRepo() {
		String status = "";
		GitHub github;
		try {
			github = GitHub.connectUsingPassword(gitUName, GitPsWrd);
			GHRepository repo = github
					.createRepository(projectName, "Created By"
							+" "+ userId+" "+"For Type"+" "+project_Type,
							" ", true/* public */);
			status = "Success";
		} catch (IOException e) {
			status = "Failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public void clonePrimaryRepo() throws IOException, GitAPIException {
		try {
			Git.cloneRepository().setURI(remotePath)
					.setDirectory(new File(localRemoPath)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pullPrimaryRepo() throws IOException, GitAPIException {
		try {
			gitPrimary.pull().setCredentialsProvider(upcp).call();
		} catch (Exception e) {
			System.out.println("Exception in pull");
			e.printStackTrace();
		}
	}

	public void checkOutPrimaryRepo() throws IOException, GitAPIException {
		try {
			gitPrimary.checkout().setAllPaths(true).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void pushChangesToNewRepo() throws IOException,
			JGitInternalException, GitAPIException {
		gitPrimary.push().setRemote(remoteNewPath)
				.setCredentialsProvider(upcp).call();
		System.out.println("pushed");
	}


	public String remoteNewPath() {
		String[] repoPath = remoteNewPath.split("//");
		String buildRepoPath = repoPath[0]+"//"+gitUName+":"+GitPsWrd+"@"+repoPath[1];		
	return buildRepoPath;
	}
	
	public String gitUrlPath() {
		return remoteNewPath;
	}
}
