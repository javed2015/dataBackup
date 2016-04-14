package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;

public class WordPressHtDocs {
	
	 
	 
	 public static void main(String[] args)
	    {	
		/* StringBuffer addConf = new StringBuffer();
		 addConf.append("<Directory /opt/bitnami/apps/myapp/htdocs>\n");
		 addConf.append("	"+"Options +FollowSymLinks\n");
		 addConf.append("	"+"AllowOverride None\n");
		 addConf.append("	"+"<IfVersion < 2.3 >\n");
		 addConf.append("	"+"Order allow,deny\n");
		 addConf.append("	"+"Allow from all\n");
		 addConf.append("	"+"</IfVersion>\n");
		 addConf.append("	"+"<IfVersion >= 2.3>\n");
		 addConf.append("	"+"Require all granted\n");
		 addConf.append("	"+"</IfVersion>\n");
		 addConf.append("</Directory>");
		 
		 
		 StringBuffer prefixConf = new StringBuffer();
		 prefixConf.append("Alias /myapp/ \"/opt/bitnami/apps/myapp/htdocs/\"\n");
		 prefixConf.append("Alias /myapp \"/opt/bitnami/apps/myapp/htdocs\"\n");
		 prefixConf.append("Include \"/opt/bitnami/apps/myapp/conf/httpd-app.conf\"\n");
		 
		 
		 
		File file = new File("C:\\VOTSH\\WordPress\\conf");
		if (!file.exists()) {
			if (file.mkdirs()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}

		File files = new File("C:\\VOTSH\\WordPress\\htdocs");
		if (!files.exists()) {
			if (files.mkdirs()) {
				System.out.println("Multiple directories are created!");
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}
		
		
		
		try {
			PrintWriter app = new PrintWriter("C:\\VOTSH\\WordPress\\conf\\httpd-app.conf", "UTF-8");
			app.println(addConf);
			app.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PrintWriter prefix = new PrintWriter("C:\\VOTSH\\WordPress\\conf\\httpd-prefix.conf", "UTF-8");
			prefix.println(prefixConf);
			prefix.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			PrintWriter prefix = new PrintWriter(new BufferedWriter(new FileWriter("C:\\VOTSH\\WordPress\\conf\\httpd-prefix.conf", true)));
		//	File fileX =new File("C:\\VOTSH\\WordPress\\conf\\httpd-prefix.conf");
			String data = "This is a test to append more data";
		//	FileWriter fileWritter = new FileWriter(fileX.getName(),true);
		//	PrintWriter prefix = new PrintWriter(fileWritter);
			prefix.println(data);
			prefix.close();
			/*BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	copyFilesToHtDocs();

	    }
	 
	 public static void copyFilesToHtDocs() {
		 
		 File source = new File("C:\\VOTSH\\Instant\\");
		 File dest = new File("C:\\VOTSH\\WordPress\\htdocs");
		 try {
		     FileUtils.copyDirectory(source, dest);
		 } catch (IOException e) {
		     e.printStackTrace();
		 }
			
		}

}
