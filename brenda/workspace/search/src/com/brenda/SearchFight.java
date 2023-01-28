package com.brenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFight {
public static Scanner inputObj;
	public static void main(String[] args) {
		
        String baseUrl_google = "";
        String baseUrl_bing = "";
	    String key = null;
	    Map<String, Integer> google = new HashMap<String, Integer>();
	    Map<String, Integer> bing = new HashMap<String, Integer>();
		inputObj = new Scanner(System.in);
	    System.out.println("------Please Enter keywords:----------");

	    String keywords = inputObj.nextLine();  // Read user input
	    
	    String strPattern = "\"([^\"]*)\"";
	      Pattern pattern = Pattern.compile(strPattern);
	      Matcher matcher = pattern.matcher(keywords);
	      ArrayList<String> list = new ArrayList<String>();

	      while( matcher.find() ) {
	    	 String eachkeyword = matcher.group(1);
	          list.add(eachkeyword);
	      }
	   
	     GoogleFight googlefight = new GoogleFight();
	     BingFight bingfight = new BingFight();
	
		
		Map<String, Integer> keyword_total_map = new HashMap<String, Integer>();
		int keyword_total = 0;
	      
		for(int i = 0;i < list.size(); i ++){
			key = list.get(i);
		    baseUrl_google = "https://www.google.com/search?q=" + key;
		    baseUrl_bing = "https://www.bing.com/search?q=" + key+"&setlang=en";
			try {
	
				google = googlefight.parsePage_google(baseUrl_google,key);
				bing = bingfight.parsePage_bing(baseUrl_bing,key);
				
				System.out.println("\n"+key+": Google :"+ google.get(key) + "\t Microsoft Bing : "+ bing.get(key)+"\n");
				
				int x = google.get(key);
				int y = bing.get(key);
				int comp = Integer.compare(x, y);
				if(comp>0) {
			         System.out.println("Google winner : " +key+"\n");
				}else if (comp<0){
				         System.out.println("Microsoft Bing winner :" + key+"\n");
				}else{
				          System.out.println("Google and Microsoft Bing Draw :" + key+"\n");
				}
				
				keyword_total = x + y; 
				keyword_total_map.put(key, keyword_total);
				
				
			} catch (Exception e) {
				System.out.println(" Search Fight Hits found Exception !!");
			}
		    
		}
		
		int max = Collections.max(keyword_total_map.values());
		String total_winner = GetMapKey.getKey(keyword_total_map, max);
		
		System.out.println("Total Winner:  "+total_winner+"\n");  

	}
	

}
