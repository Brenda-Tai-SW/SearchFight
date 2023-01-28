package com.brenda;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoogleFightTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testParsePage_google() {
		 GoogleFight googlefight = new GoogleFight();
		    String a =  "https://www.google.com/search?q=JAVA"  ;
		    String b = "JAVA";
		    Map<String, Integer> map = null;
			try {
				map = googlefight.parsePage_google(a, b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    int actual = 0;
			
			    for (Map.Entry<String, Integer> entry : map.entrySet()) {
		        String mapKey = entry.getKey();
		        int mapValue = entry.getValue();
		        System.out.println(mapKey + "：" + mapValue);
		        actual = mapValue;
				
			    }
			    System.out.println( actual);
		 
		    int expected = 1460000000;
		 
		    assertEquals(expected, actual);
	}

}
