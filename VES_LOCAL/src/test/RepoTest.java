package test;


public class RepoTest {
	
	public static void main(String []args) {
		
		
		String remotePath = "https://github.com/javed2015/TesJav.git";
		String[] rPath = remotePath.split("/");
		System.out.println(rPath[0]+"//"+rPath[1]+rPath[2]+"/"+rPath[3]+"/");
		
	}
}
