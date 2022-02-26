package com.metinkuzey.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.codec.digest.DigestUtils;


public class List2ListJava8 {

	public static void main(String[] args) {
		
		List2ListJava8 o = new List2ListJava8();
		
		List<String> myList = Arrays.asList("java",".net","javascript","angular","react","sql");
		List<String> result = o.map(myList, o::sha256);
        System.out.println("---------------------------------------------");
		result.forEach(System.out::println);
        result = o.map(myList, o::sha512);
        System.out.println("---------------------------------------------");
        result.forEach(System.out::println);
		

	}
	
    public <T, R> List<R> map(List<T> list, Function<T, R> func) {

        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(func.apply(t));
        }
        return result;

    }

    public String sha256(String str) {
        return DigestUtils.sha256Hex(str);
    }

    public String sha512(String str) {
        return DigestUtils.sha512Hex(str);
    }

}
