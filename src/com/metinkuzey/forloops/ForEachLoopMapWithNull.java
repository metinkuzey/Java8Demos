package com.metinkuzey.forloops;

import java.util.HashMap;
import java.util.Map;

public class ForEachLoopMapWithNull {

	public static void main(String[] args) {
	      Map<String, Integer> asciiMap = new HashMap<>();
	      asciiMap.put(null, 65);
	      asciiMap.put("B", 66);
	      asciiMap.put("C", 67);
	      asciiMap.put("D", 68);
	      asciiMap.put("M", 77);
	      asciiMap.put("E", null);
	      asciiMap.put("T", 84);
	      asciiMap.put("I", 73);
	      asciiMap.put("N", 78);
	      asciiMap.put("K", 75);
	      asciiMap.put("U", 85);
	      asciiMap.put("Z", 90);
	      asciiMap.put("E", null);
	      asciiMap.put("Y", 89);
	      System.out.println("********************** Print the map ************************");
	      if(asciiMap != null)
	    	  asciiMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
	      
	      System.out.println("********** Print the map which its key is not null **********");
	      //if we don't write the null keys
	      asciiMap.forEach(
	              (k, v) -> {
	                  // we add null check for keys
	                  if (k != null){
	                      System.out.println("Key : " + k + ", Value : " + v);
	                  }
	              }
	          );

	      System.out.println("********** Print the map which its value is not null **********");
	      //if we don't write the null values
	      asciiMap.forEach(
	              (k, v) -> {
	                  // we add null check for values
	                  if (v != null){
	                      System.out.println("Key : " + k + ", Value : " + v);
	                  }
	              }
	          );	      

	}

}
