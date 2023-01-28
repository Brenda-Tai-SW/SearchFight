package com.brenda;

import java.io.IOException;
import java.util.Map;

public interface GoogleFightInterface {
	Map<String, Integer> parsePage_google(String src,String key) throws IOException;

}