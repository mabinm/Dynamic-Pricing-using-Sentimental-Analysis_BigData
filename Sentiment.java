 
/*
 * This program takes the input from sentimentalAnalysis.java and gives a sentiment score
 * to each tweet based on the words present in the list of positive and negative words
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Sentiment {

     public static void main(String[] args) throws IOException{
    	 //Store positive and negative words into ArrayLists
    	 ArrayList<String> positive = new ArrayList<String>();
    	 ArrayList<String> negative = new ArrayList<String>();
    	 
    	 BufferedReader br1 = new BufferedReader(new FileReader("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/positive-words.txt"));
    	 BufferedReader br2 = new BufferedReader(new FileReader("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/negative-words.txt"));
    	 BufferedReader br3 = new BufferedReader(new FileReader("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/No_Stop_words_Tweet.txt"));
    	 FileWriter f = new FileWriter("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/Polarity_final.txt");
    	 
    	 int polarity = 0;
    	 
    	 try{
    		 String line;
    		 while((line = br1.readLine()) != null) 
    			 positive.add(line);
    		 br1.close();
    		 while((line = br2.readLine()) != null) 
    			 negative.add(line);
    		 br2.close();
             while((line = br3.readLine()) != null){
            	 ArrayList<String> tweets  = new ArrayList<String>();
				 String [] tweet = line.split(",",3);  //break line read into individual tokens
			    String input = tweet[1];	
				String[] elements = input.split(" ");	
				for(String str : elements)
					tweets.add(str.trim());
            	
				//check if positive words are there
				for(String s:tweets)
				{ 
					boolean ispos = positive.contains(s);
					if(ispos == true) {polarity++;System.out.println(s + " : positive word");break;} 
					boolean isneg = negative.contains(s);
					if(isneg == true) {polarity--;System.out.println(s + " : negative word");break;}	
                    if(ispos == false && isneg == false) System.out.println(s + " : no match found");
             }
				System.out.println("Final polarity of tweet is " + polarity);
				String result_to_write = tweet[0] +"," + tweet[1] + "," + polarity;
				f.write(result_to_write + "\n");
				polarity = 0;
				
             } //reading br3 while loop
             f.flush();
             f.close();
    	 }
    	 catch(FileNotFoundException e){
    		 e.printStackTrace();
    	 }
     } //for main method
	
} //for class Sentiment
