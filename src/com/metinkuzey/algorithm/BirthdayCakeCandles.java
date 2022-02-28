package com.metinkuzey.algorithm;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Documents\\output.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // give the candles of cake. For example: 4 4 1 3 4
        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int birthdayCakeCandles(List<Integer> candles){
        int max = candles.get(0);
        int count = 0;
        for (int i = 0; i < candles.size(); i++) {
            if (candles.get(i)>max)
                max = candles.get(i);
        }
        for (int i = 0; i < candles.size(); i++) {
            if(candles.get(i) == max)
                count++;
        }
        return count;
    }
}
