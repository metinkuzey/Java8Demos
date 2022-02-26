package com.metinkuzey.forloops;

import java.util.HashMap;
import java.util.Map;

public class ClassicLoopMap {

	public static void main(String[] args) {
	      Map<String, Integer> asciiMap = new HashMap<>();
	      asciiMap.put("A", 65);
	      asciiMap.put("B", 66);
	      asciiMap.put("C", 67);
	      asciiMap.put("D", 68);
	      asciiMap.put("M", 77);
	      asciiMap.put("E", 69);
	      asciiMap.put("T", 84);
	      asciiMap.put("I", 73);
	      asciiMap.put("N", 78);
	      asciiMap.put("K", 75);
	      asciiMap.put("U", 85);
	      asciiMap.put("Z", 90);
	      asciiMap.put("E", 69);
	      asciiMap.put("Y", 89);

	      for (Map.Entry<String, Integer> entry : asciiMap.entrySet()) {
	          System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
	      }
	}

}
