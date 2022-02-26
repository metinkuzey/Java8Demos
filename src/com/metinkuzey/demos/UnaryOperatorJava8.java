package com.metinkuzey.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorJava8 {

	public static void main(String[] args) {
		Function<Integer, Integer> func = x -> x * 2;

		Integer result = func.apply(2);

		System.out.println(result); // 4

		UnaryOperator<Integer> func2 = x -> x * 2;

		Integer result2 = func2.apply(2);

		System.out.println(result2); // 4

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> result3 = math(list, x -> x * 2);

		System.out.println(result3); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

		List<Integer> result4 = mathListChain(list, x -> x * 2, x -> x + 1);

		System.out.println(result4); // [3, 5, 7, 9, 11, 13, 15, 17, 19, 21]

	}

	public static <T> List<T> math(List<T> list, UnaryOperator<T> uo) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(uo.apply(t));
		}
		return result;
	}

	public static <T> List<T> mathListChain(List<T> list, UnaryOperator<T> uo, UnaryOperator<T> uo2) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(uo.andThen(uo2).apply(t));
		}
		return result;
	}

}
