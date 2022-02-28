package com.metinkuzey.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Documents\\output.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    /* https://www.hackerrank.com/challenges/breaking-best-and-worst-records/
    * Mark plays college basketball and wants to go pro.
    * Each season he maintains a record of his play.
    * He tabulates the number of times he breaks his season record
    * for most points and least points in a game.
    * Points scored in the first game establish his record for the season,
    * and he begins counting from there.
                                            Count
            Game  Score  Minimum  Maximum   Min Max
             0      12     12       12       0   0
             1      24     12       24       0   1
             2      10     10       24       1   1
             3      24     10       24       1   1
     * Given the scores for a season,
     * determine the number of times Player breaks her records for most
     * and least points scored during the season.
     *
     * Function Description
     * Complete the breakingRecords function in the editor below.
     * breakingRecords has the following parameter(s):
     * int scores[n]: points scored per game
     *
     * Returns
     * int[2]: An array with the numbers of times she broke players records.
     * Index 0 is for breaking most points records, and index 1 is for breaking least points records.
     *
     *
    * */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int highest, lowest;
        highest = lowest = scores.get(0);

        List<Integer> result = new ArrayList<>();
        int min =0, max = 0;

        for (int i = 1; i < scores.size(); i++)
        {
            if (scores.get(i) > highest)
            {
                highest = scores.get(i);
                max++;
            }
            else if (scores.get(i) < lowest)
            {
                lowest = scores.get(i);
                min++;
            }
        }
        result.add(max);
        result.add(min);
        return result;

    }

}
