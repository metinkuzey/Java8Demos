package com.metinkuzey.demos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFilterJava8 {

	public static void main(String[] args) {

		// GENERAL STREAM FILTER
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
		System.out.println(collect); // [6, 7, 8, 9, 10]

		// PREDICATE ARGUMENTS
		Predicate<Integer> noGreaterThan5 = x -> x > 5;
		collect = list.stream().filter(noGreaterThan5).collect(Collectors.toList());

		System.out.println(collect); // [6, 7, 8, 9, 10]

		// STREAM AND FILTER
		collect = list.stream().filter(x -> x > 5 && x < 8).collect(Collectors.toList());

		System.out.println(collect);
		// PREDICATE AND FILTER
		Predicate<Integer> noLessThan8 = x -> x < 8;
		collect = list.stream().filter(noGreaterThan5.and(noLessThan8)).collect(Collectors.toList());

		// PREDICATE OR FILTER
		Predicate<String> lengthIs3 = (x) -> (x.length() == 3);
		Predicate<String> startWithA = (x) -> (x.startsWith("A"));

		List<String> list2 = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

		List<String> collect2 = list2.stream().filter(lengthIs3.or(startWithA)).collect(Collectors.toList());

		System.out.println(collect2);

		// PREDICATE NEGATE
		collect2 = list2.stream().filter(startWithA.negate()).collect(Collectors.toList()); // RETURNS NOT STARTED WITH
																							// "A"

		System.out.println(collect2);

		// PREDICATE TEST FUNCTION
		System.out.println(StringProcessor.filter(list2, x -> x.startsWith("A"))); // [A, AA, AAA]

		System.out.println(StringProcessor.filter(list2, x -> x.startsWith("A") && x.length() == 3)); // [AAA]
		
		//PREDICATE CHAIN
        Predicate<String> startWithLoverA = x -> x.startsWith("a");

        // start with "a" or "m"
        boolean result = startWithLoverA.or(x -> x.startsWith("m")).test("metin");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithLoverA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);    // false

	}

}

class StringProcessor {
	static List<String> filter(List<String> list, Predicate<String> predicate) {
		return list.stream().filter(predicate::test).collect(Collectors.toList());
	}
}
