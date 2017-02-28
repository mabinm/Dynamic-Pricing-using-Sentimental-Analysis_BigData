package maven.bigdata.cs595;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.*;
import com.github.scribejava.core.builder.api.*;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.*;


public class TwitterStreamConsumer extends Thread {

    private static final String STREAM_URI = "https://stream.twitter.com/1.1/statuses/filter.json";

    public void run(){
        try{
            System.out.println("Starting Twitter public stream consumer thread.");
            String tweet;
            FileWriter f = new FileWriter("C:/Users/Admin/Documents/MCS Documents/Spring 2016/CS595/Project/Project_Twitter_Data15.json");

            // Enter your consumer key and secret below
            OAuth10aService service = new ServiceBuilder()
                    .apiKey("NZ3HlUd0FCTPWfUOn1fOSvW2X")
                    .apiSecret("kOGkFvmEsss7AwIruEEDATSQ4nCgBiybktODzfDSOGJbtVhShk")
                    .build(TwitterApi.instance());

            // Set your access token
            OAuth1AccessToken accessToken = new OAuth1AccessToken("702805707813335040-vrbHxatGllQMfN6VwTZf3fqlbJ8MU3S", "LD4nYlO02PfROQEsQk8W9V8YS5LaEgBWTTF6ckMQetTIN");

            // Let's generate the request
            System.out.println("Connecting to Twitter Public Stream");
            OAuthRequest request = new OAuthRequest(Verb.POST, STREAM_URI,service);
            request.addHeader("version", "HTTP/1.1");
            request.addHeader("host", "stream.twitter.com");
            request.setConnectionKeepAlive(true);
            request.addHeader("user-agent", "Twitter Stream Reader");
            request.addBodyParameter("track", "electric"); // Set keywords you'd like to track here
          
            service.signRequest(accessToken, request);
            Response response = request.send();

            // Create a reader to read Twitter's stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                tweet = line ;
                f.write(tweet + "\n");
            }
            f.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}