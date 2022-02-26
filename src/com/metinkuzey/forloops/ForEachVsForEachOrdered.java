package com.metinkuzey.forloops;

import java.util.stream.Stream;

public class ForEachVsForEachOrdered {

	public static void main(String[] args) {

		Stream<String> s1 = Stream.of("M", "T", "N", "2", "7", "4");
		// each run will generate different output result
		System.out.println(">>>>>>>>>>>>>>>> ForEach Output Result:");
		s1.parallel().forEach(x -> System.out.println(x));

		Stream<String> s2 = Stream.of("M", "T", "N", "2", "7", "4");
		// keep order, it is always a,b,c,1,2,3
		System.out.println(">>>>>>>>>>>>>>>> ForEachOrdered Output Result:");
		s2.parallel().forEachOrdered(x -> System.out.println(x));

	}

}
