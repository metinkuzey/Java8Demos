package com.metinkuzey.demos;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorJava8 {

	public static void main(String[] args) {
        // BiFunction
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;

        Integer result = func.apply(2, 3);

        System.out.println(result); // 5

        // BinaryOperator
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;

        Integer result2 = func.apply(2, 3);

        System.out.println(result2); // 5
        
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer result3 = math(Arrays.asList(numbers), 0, (a, b) -> a + b);

        System.out.println(result3); // 55

        Integer result4 = math(Arrays.asList(numbers), 0, Integer::sum);

        System.out.println(result4); // 55
        
        int[] numbersInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int result5 = mathStream((numbersInt), 0, (a, b) -> a + b);

        System.out.println(result5); // 55

        int result6 = mathStream((numbersInt), 0, Integer::sum);

        System.out.println(result6); // 55

	}
	
    public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator) {
        T result = init;
        for (T t : list) {
            result = accumulator.apply(result, t);
        }
        return result;
    }
    
    public static int mathStream(int[] list, int init, IntBinaryOperator accumulator) {
        int result = init;
        for (int t : list) {
            result = accumulator.applyAsInt(result, t);
        }
        return result;
    }

}
