package com.metinkuzey.demos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerJava8 {

	public static void main(String[] args) {
		Consumer<String> print = x -> System.out.println(x);
        print.accept("java 8 consumer");
        
        
        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5);
        List<String> listStr = Arrays.asList("a", "ab", "abc");

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumerInt = (Integer x) -> System.out.println(x);
        forEach(listInteger, consumerInt);
        Consumer<String> consumerStr = (String x) -> System.out.println(x);
        forEach(listStr, consumerStr);

        System.out.println("-------------------------------------------------------");        
        
        // or call this directly
        forEach(listInteger, (Integer x) -> System.out.println(x));        
        forEach(listStr, (String x) -> System.out.println(x.length()));

	}
	
	static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

}
