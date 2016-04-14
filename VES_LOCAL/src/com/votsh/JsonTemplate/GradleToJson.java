package com.votsh.JsonTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;

public class GradleToJson {

	public String toJson() {
		String status = "New Project Successfully Created";
		Scanner s;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String spcs = "  ";
		StringBuffer header = new StringBuffer("{\n");
		header.append(spcs + "\"ProjectName\": \"InstantWinApp\",\n");
		header.append(spcs
				+ "\"Desc\": \"InstantWinApp is an redemption APP.\",\n");
		header.append(spcs + "\"CreatedBy\": \"Javed\",\n");
		header.append(spcs + "\"CreatedDate\": \"mm/dd/yyyy\",\n");
		header.append(spcs + "\"Language\": \"java\",\n");
		header.append(spcs + "\"Version\":\"1.8\",\n");
		header.append(spcs + "\"LastUpdated\": \"" + dateFormat.format(date)
				+ "\",\n");
		header.append(spcs + "\"Type\": \"Redemption\",\n");
		header.append(spcs + "\"Platform\": [{\n");
		header.append(spcs + spcs + "\"Type\" : \"web\",\n");
		header.append(spcs + spcs + "\"Config\" : [{\n");
		header.append(spcs + spcs + "\"Key\" : \"Server\",\n");
		header.append(spcs + spcs + "\"Value\" : \"Tomcat8\"\n");
		header.append(spcs + "}]\n");
		header.append(spcs + "},{\n");
		header.append(spcs + spcs + "\"Type\" : \"android\",\n");
		header.append(spcs + spcs + "\"Config\" : [{\n");
		header.append(spcs + spcs + "\"Key\" : \"avd\",\n");
		header.append(spcs + spcs + "\"Value\" : \"Android-Nexus6\"\n");
		header.append(spcs + "}]\n");
		header.append(spcs + "}],\n");
		header.append(spcs + "\"Repository\" : {\n");
		header.append(spcs + spcs + "\"Type\": \"git\",\n");
		header.append(spcs + spcs
				+ "\"Path\": \"git@github.com:frankcohen/v.git\"\n");
		header.append(spcs + "},\n");
		header.append(spcs + "\"Source\" : {\n");
		header.append(spcs + spcs + "\"default\": [{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/main/java\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Application/Library sources\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/main/filters\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Resource filter files\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/main/config\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Configuration files\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/main/webapp\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Web application sources\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/test/java\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Test sources\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/test/resources\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Test resources\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs
				+ "\"directory\": \"src/test/filters\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Test resource filter files\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs + "\"directory\": \"src/it\",\n");
		header.append(spcs
				+ spcs
				+ spcs
				+ "\"description\": \"Integration Tests (primarily for plugins)\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs + "\"directory\": \"src/assembly\",\n");
		header.append(spcs + spcs + spcs
				+ "\"description\": \"Assembly descriptors\"\n");
		header.append(spcs + spcs + "},{\n");
		header.append(spcs + spcs + spcs + "\"directory\": \"src/site\",\n");
		header.append(spcs + spcs + spcs + "\"description\": \"Site\"\n");
		header.append(spcs + spcs + "}],\n");
		try {
			s = new Scanner(new File(
					"/tmp/VOTSH/TesJav/InstantWinApp/ProjectStructure.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()) {
				list.add(s.nextLine());
			}
			ListIterator<String> itr = list.listIterator();
			StringBuffer value = new StringBuffer(header + "\"Structure\" : [");
			String prev = null;
			while (itr.hasNext()) {
				String str = itr.next();
				if (str.contains(".")) {
					String[] parts = str.split("/");
					String part1 = parts[parts.length - 1];
					value = value.append("{");
					value = value.append("\n" + spcs + spcs + spcs + spcs
							+ " \"Type\" : \"File\",");
					value = value.append("\n" + spcs + spcs + spcs + spcs + " "
							+ "\"Name\" : " + "\"" + part1 + "\"");
					value = value
							.append("\n" + spcs + spcs + spcs + spcs + "}");
				} else {
					value = value.append("]},{");
					value = value.append("\n" + spcs
							+ "\"Type\" : \"directory\",");
					value = value.append("\n" + spcs + "\"Name\" : \"" + str
							+ "\",");
					value = value.append("\n" + spcs + " \"in\" : [");
				}
			}

			// Closing the brackets statically
			value = value.append("]" + "\n" + spcs + spcs + spcs + spcs + "}]"
					+ spcs + "\n" + spcs + spcs + "}]");
			value = value.append("\n" + spcs + spcs + spcs + spcs + "}]" + "\n"
					+ spcs + spcs + "}]" + "\n" + spcs + spcs + "}" + "\n"
					+ spcs + spcs + spcs + "]");
			value = value.append("\n" + "}" + "\n" + "\n" + "}");

			prev = value.toString();
			prev = prev.replace("[]},{", "[{");
			prev = prev.replace("}{", "},{");
			System.out.println(prev);
			try {
				File file = new File(
						"/tmp/VOTSH/TesJav/JsonTemplate/PTemplate.json");
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(prev);
				bw.close();
				System.out.println("Done");
			} catch (IOException e) {
				e.printStackTrace();
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return status;
	}

}
