package com.brenda;

import java.io.IOException;
import java.util.Map;

public interface BingFightInterface {
	Map<String, Integer> parsePage_bing(String src,String key) throws IOException;

}