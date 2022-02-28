package com.metinkuzey.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MaxAndMinSumOfArrayElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

        minMaxSum(arr);
        bufferedReader.close();
    }
    /**
     * Given five positive integers, find the minimum and maximum values
     * that can be calculated by summing exactly four of the five integers.
     * Then print the respective minimum and maximum values as a single line of
     * two space-separated long integers.
     * **/

    public static void minMaxSum(List<Integer> arr) {
        long min = 0, max = 0, sum = 0;
        min = arr.get(0);
        max = min;
        sum = min;
        for (int i = 1; i < arr.size(); i++) {//set i value to 1, because ve want to find 4 member sum.
            sum += arr.get(i);
            if (arr.get(i)<min){
                min = arr.get(i);
            }
            if (arr.get(i)>max){
                max = arr.get(i);
            }
        }
        //(sum -max) = minimum sum of 4 member of array
        //(sum -min) = maximum sum of 4 member of array
        System.out.println((sum -max) + " " + (sum -min) );


    }
}
