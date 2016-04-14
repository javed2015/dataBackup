package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WordpressJSONTest {
	
	public static void main(String []args){
		JSONArray buildJsonArray = new JSONArray();
		StringBuffer sb = new StringBuffer();
		try {
			Scanner s = new Scanner(new File(
					"C:\\tmp\\NewFile.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()) {
				list.add(s.nextLine());
			}
			Iterator<String> itr = list.iterator();
			while(itr.hasNext()){
				JSONObject buildObject = new JSONObject();
				buildObject.put("Type", itr.next());
			
				if(itr.hasNext()){				
					
					buildObject.put("Name", itr.next());
				}
				//String json = buildObject.toString();
				buildJsonArray.put(buildObject);
				
				
			}
			try {
				File file = new File(
						"C:\\tmp\\WordTemplate.json");
				if (!file.exists()) {
					file.createNewFile();
				}
				String str = buildJsonArray.toString();
				String split = str.replace("},{", "\n},{\n");
			String sol = split.replace("\",\"", "\",\n\"");
				/*for(int i=0;i<split.length;i++){
					sb.append(split[i]+"},\n{");
				}*/
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(sol);
				bw.close();
				System.out.println("Done");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			//System.out.println(buildJsonArray);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			catch (JSONException e) {
//		 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
