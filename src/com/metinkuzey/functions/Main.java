package com.metinkuzey.functions;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		String fullName = "MetinKuzey";
        Function<String, Integer> func = x -> x.length();
        // You can write code like this --> Function<String, Integer> func = String::length;
        Integer apply = func.apply(fullName);
        System.out.println(apply);
        
        Function<Integer, Integer> func2 = x -> x * 2;
        Integer result = func.andThen(func2).apply(fullName);
        System.out.println(result);
	}

}
