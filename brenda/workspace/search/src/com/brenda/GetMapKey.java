package com.brenda;

import java.util.Map;


public class GetMapKey {

 public static  <K, V> K getKey(Map<K, V> map, V value){
        return map.entrySet().stream()
                .filter(entry -> value.equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);
    }
	
}
