package com.metinkuzey.forloops;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForEachConsumer {

	public static void main(String[] args) {
        List<String> list = Arrays.asList(".net", "java", "sql");
        Stream<String> stream = Stream.of(".net", "java", "sql");

        // convert a String to a Hex
        Consumer<String> printTextInHexConsumer = (String x) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : x.toCharArray()) {
                String hex = Integer.toHexString(c);
                sb.append(hex);
            }
            System.out.println(String.format("%n%-10s:%s", x, sb.toString()));
        };

        System.out.println("************* Printing consumer using List Object ***************");
        list.forEach(printTextInHexConsumer);
        System.out.println("************* Printing consumer using Stream Object ***************");
        stream.forEach(printTextInHexConsumer);

	}

}
