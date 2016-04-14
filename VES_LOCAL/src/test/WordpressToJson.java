package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class WordpressToJson {
	
	private static File index = new File("C:\\tmp\\NewFile.txt");
	 static ArrayList<File> al = new ArrayList<File>();
	/*
	public static void main(String []args) throws IOException{		
		listf("C:\\tmp\\content-template", al);
		 Iterator itr = al.iterator();
		 int count=0;
		
		 while(itr.hasNext()){
			 PrintWriter prefix = new PrintWriter(new BufferedWriter(new FileWriter(index, true)));
			 Object data = itr.next();
			 prefix.println(data);
				prefix.close();
	//	int slno = count++;
	//		 System.out.println(slno+" "+itr.next());
		 }
		 System.out.println(al.size());
	}*/
	
	/*public static void main(String[] args) throws IOException {

		File dir = new File("C:\\tmp\\content-template");

		System.out.println("Getting all files in " + dir.getCanonicalPath() + " including those in subdirectories");
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			
			 PrintWriter prefix = new PrintWriter(new BufferedWriter(new FileWriter(index, true)));
			 Object data = "file: " + file.getCanonicalPath();
			 prefix.println(data);
				prefix.close();
			System.out.println("file: " + file.getCanonicalPath());
		}

	}*/
	 
	 static StringBuffer data =  new StringBuffer();
	
	 public static void main(String[] args) throws IOException {
		 File dir = new File("C:\\tmp\\content-template");
		//	File currentDir = new File("."); // current directory
			displayDirectoryContents(dir);
			 PrintWriter prefix = new PrintWriter(new BufferedWriter(new FileWriter(index, true)));
		//	 data.append("     "+"file: " + file.getName());
			 prefix.println(data);
				prefix.close();
			System.out.println("success");
		}

		public static void displayDirectoryContents(File dir) {
			
				File[] files = dir.listFiles();
				for (File file : files) {
				//	StringBuffer data =  new StringBuffer();
					 if (file.isFile()){
					//	 PrintWriter prefix = new PrintWriter(new BufferedWriter(new FileWriter(index, true)));
					//	 data.append("     "+"\"Type\""+ ":"+"\"file\",\n" +"     "+"\"Name\" :"+"\""+ file.getName()+"\"\n");
						 data.append("file\n" +file.getName()+"\n");
					//	 prefix.println(data);
					//		prefix.close();
						//System.out.println("     file:" + file.getCanonicalPath());
					}
				}for (File file : files) {
				//	StringBuffer data =  new StringBuffer();
					if (file.isDirectory()) {
					//	 PrintWriter prefix = new PrintWriter(new BufferedWriter(new FileWriter(index, true)));
					//	data.append("\"Type\""+ ":"+ "\"directory\""+",\n"  +"\"Name\" :"+"\""+ file.getName()+"\"\n");
						data.append("directory"+",\n"  +file.getName()+"\n");
					//	 prefix.println(data);
					//		prefix.close();
					//	System.out.println("directory:" + file.getCanonicalPath());
							displayDirectoryContents(file);
					}
					
				}
				
		
			
		}
	
	
	
	
	public static void listf(String directoryName, ArrayList<File> files) {
	    File directory = new File("C:\\tmp\\content-template");

	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile()) {
	            files.add(file);
	        } else if (file.isDirectory()) {
	            listf(file.getAbsolutePath(), files);
	        }
	    }
	   
	}
	

}
