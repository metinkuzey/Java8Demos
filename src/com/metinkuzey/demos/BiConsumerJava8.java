package com.metinkuzey.demos;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerJava8 {

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
	    addTwo.accept(1, 2);
	    System.out.println("------------------------------------------------------");
	    addTwoFunc(1, 2, (x, y) -> System.out.println(x + y)); 
	    addTwoFunc("Node", ".js", (x, y) -> System.out.println(x + y));
	    System.out.println("------------------------------------------------------");
        math(5, 23, (x, y) -> System.out.println(x + y));
        math(9, 49, (x, y) -> System.out.println(x - y));
        math(87, 3, (x, y) -> System.out.println(x * y));
        math(25, 5, (x, y) -> System.out.println(x / y));
        System.out.println("------------------------------------------------------");
        //Java Map Source Codes : Map.forEach accepts a BiConsumer as an argument.
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "SQL");
        map.put(2, "C#");
        map.put(3, "Perl");
        map.put(4, "Node.js");
        map.put(5, ".Net");
        map.put(6, "React");
        map.put(7, "Java");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

	}
	
    static <T> void addTwoFunc(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }
    
    static <Integer> void math(Integer a1, Integer a2, BiConsumer<Integer, Integer> c) {
        c.accept(a1, a2);
    }

}
