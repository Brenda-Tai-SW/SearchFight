package com.brenda;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleFight implements GoogleFightInterface {

	static Map<String, Integer> google_map = new HashMap<String, Integer>();

	public  Map<String, Integer> parsePage_google(String src,String key) throws IOException {
		Document document = Jsoup.connect(src).get();
		String google_hit = document.getElementById("result-stats").text();

		
		String regEx="[^0-9\b'(']";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(google_hit);  
		String n = m.replaceAll("").trim();
		
		String google_hits_str = n.substring(0, n.indexOf("("));
		int google_hits_int = Integer.parseInt(google_hits_str);

		google_map.put(key, google_hits_int);

	    
	    return google_map;
	}

}