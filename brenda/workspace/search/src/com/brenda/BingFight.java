package com.brenda;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BingFight implements BingFightInterface {

    static Map<String, Integer> bing_map = new HashMap<String, Integer>();


	public  Map<String, Integer>  parsePage_bing(String src,String key) throws IOException {
		Document document = Jsoup.connect(src).get();
		String bing_hit ="";

//		 bing_hit = document.getElementsByClass("sb_count").first().text();
//		 Elements elements = document.select("b_tween > span");
//		 
//	     for (Element element : elements) {
//	            String sb_count = element.select("span.sb_count").first().text();
//	            System.out.println("sb_count : " + sb_count );
//	        }
		 bing_hit = document.getElementById("b_content").text();
		 
         Pattern pattern = Pattern.compile("About(.*?)result");
         Matcher matcher = pattern.matcher(bing_hit);
         String number = "";
         int i = 0;
         while (matcher.find()) {
       	  number = matcher.group(1).trim();
       	  number = number.replaceAll("\\s","");
          i = Integer.parseInt(number);
         }
         
         bing_map.put(key, i);
	
 	    return bing_map;

	}

}