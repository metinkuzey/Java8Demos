package com.metinkuzey.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairCase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        staircase(n);
        bufferedReader.close();
    }
    /**************************************************
     * this function write a result like staircase.
     * For example if we give 7 integer values as an input for step count.
     * Result is below:
     *       #
     *      ##
     *     ###
     *    ####
     *   #####
     *  ######
     * #######
     ******************************************************/
    public static void staircase(int n){
        for (int i = 1; i <= n; i++) {
            System.out.println(new String(new char[n-i]).replace("\0", " ") +
                               new String(new char[i]).replace("\0", "#"));
        }
    }
}
