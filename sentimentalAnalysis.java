

/*
 * This program takes the input from Parser.java and removes the stop words from each 
 * tweet
 */
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;


public class sentimentalAnalysis {

	public static void main(String[] args){
		BufferedReader br = null;
		
		try{
			String line;
			br = new BufferedReader(new FileReader("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/Mabin_data_final.txt"));
			FileWriter f = new FileWriter("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/No_Stop_words_Tweet.txt");
			while((line = br.readLine()) != null){
				ArrayList<String> tweets  = new ArrayList<String>();
				 
				
				 String [] tweet = line.split(",",3);  //break line read into individual tokens
			    String input = tweet[1];
				
				String[] elements = input.split(" ");
				
				
				for(String str : elements)
					tweets.add(str.trim());
				
				BufferedReader breader = new BufferedReader(new FileReader("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/Stop_words.txt"));
				
				String bline;
				while((bline = breader.readLine()) != null){
					 
					Iterator itr = tweets.iterator();
					while(itr.hasNext()){
					 String tocheck = (String)itr.next();
					 
					if(bline.equalsIgnoreCase(tocheck))
						itr.remove();
					} //for while loop
	
				} 
				//Stop words are removed from tweets ArrayList
				//Rebuild the tweets after stop words removal
				StringBuilder sb = new StringBuilder();
				for(String s : tweets)
				sb.append(s + " ");
				String stop_Words_Remove_Tweet = sb.toString();
				String result = tweet[0] + "," + stop_Words_Remove_Tweet;
				System.out.println(result);
				
				f.write(result + "\n");
				
				}
			f.flush();
			f.close();
			}
			 
	 
		 catch (Exception e) {
				e.printStackTrace();
			} 
	}
	
}




