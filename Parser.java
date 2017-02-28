
/*  
 * This program takes the tweet as a json object and parses the date and text field
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import org.json.simple.parser.*;
import org.json.simple.*;


public class Parser {

	public static void main(String[] args){
		
		BufferedReader br = null;
		JSONParser parser = new JSONParser();
		
		try{
			String currentLine;
			
			FileWriter f = new FileWriter("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/Mabin_data_final.txt");
			br = new BufferedReader(new FileReader("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/Project_Twitter_Data.json")); 
			
			while((currentLine = br.readLine()) != null){
				
				Object obj = parser.parse(currentLine.toString());
				JSONObject jsonObject = (JSONObject) obj;
				
				String lang = (String) jsonObject.get("lang");
				if(lang.equals("en")){
					String created_at = (String) jsonObject.get("created_at");
					StringBuffer sb = new StringBuffer();
					sb.append(created_at + ",");
					 
					
					String tweet = ((String) jsonObject.get("text"));
					String mod = tweet.replaceAll(",", "");
					sb.append(tweet + "\n");
					System.out.println(sb);
					sb.append(System.getProperty("line.separator"));
					f.write(sb.toString());
				}
						
			}
			 
			f.flush();
			f.close();
		}
		 catch (Exception e) {
				e.printStackTrace();
			} 
		 
	}
}
