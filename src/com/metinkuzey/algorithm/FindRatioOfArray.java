package com.metinkuzey.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindRatioOfArray {
    // we will find the array's element ratio
    // for example: arr = [1,3,0,-2,-6, -1]
    // we'll find positive element's count of array. it is 2(1,3)
    // we'll find negative element's count of array. it is 3(-2,-6,-1)
    // we'll find the zero element's count of array. it is 1(0)
    // we return all integer type's ratios. Formula: counts of type / arr.size()
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }
    public static void plusMinus(List<Integer> arr){
        var countOfPositive = (int) arr.stream().filter(i -> i > 0).count();
        var countOfNegative = (int) arr.stream().filter(i -> i < 0).count();
        var countOfZero = (int) arr.stream().filter(i -> i == 0).count();
        var n = arr.size();
        System.out.printf("%6f%n", (double) countOfPositive / (double) n);
        System.out.printf("%6f%n", (double) countOfNegative / (double) n);
        System.out.printf("%6f%n", (double) countOfZero / (double) n);
    }

}


