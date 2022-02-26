package com.metinkuzey.functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class List2MapJava8 {

	public static void main(String[] args) {
		List2MapJava8 o = new List2MapJava8();
		List<String> myList = Arrays.asList("java",".net","javascript","angular","react","sql");
		
		Map<String, Integer> myMap1 = o.convertListToMap(myList, x -> x.length());		
		System.out.println(myMap1);
        System.out.println("---------------------------------------------");
		Map<String, Integer> myMap2 = o.convertListToMap(myList, o::getLength);
		System.out.println(myMap2);
        System.out.println("---------------------------------------------");
	}
	
    public <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {

        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;

    }

    public Integer getLength(String str) {
        return str.length();
    }

}
