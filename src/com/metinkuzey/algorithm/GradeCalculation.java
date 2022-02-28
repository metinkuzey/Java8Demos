package com.metinkuzey.algorithm;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * University has the following grading policy:
 *
 * Every student receives a grade in the inclusive range from 0 to 100.
 * Any grade less than 40 is a failing grade.
 * Sam is a professor at the university and likes to round each student's grade according to these rules:
 *
 * If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
 * If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 *
 * Examples *
 *  grade = 84 --> round to  (85 - 84 is less than 3)
 *  grade = 29 --> do not round (result is less than 40)
 *  grade = 57 --> do not round (60 - 57 is 3 or higher)
 * Given the initial value of grade for each of Sam's  students, write code to automate the rounding process.
 *
 * Function Description
 * Complete the function gradingStudents in the editor below.
 * gradingStudents has the following parameter(s):
 * int grades[n]: the grades before rounding
 *
 * Returns
 * int[n]: the grades after rounding as appropriate
 * Input Format
 *
 * The first line contains a single integer, n, the number of students.
 * Each line i of the n subsequent lines contains a single integer, grades[i].
 *
 * Constraints
 * 1<=n<=60
 * 0<=grades[i]<=100
 *
 * Sample Input -> 5 / 77 63 38 23 88
 * **/

public class GradeCalculation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Documents\\output.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int marks:grades){
            if(marks < 38 || marks % 5 <= 2){//set the professor grade rule here, fail grades and not needed round grades
                ans.add(marks);
            }else if(marks % 5 > 2){// we set the rounded grades here
                int add = 5 -(marks % 5);
                ans.add(marks + add);
            }
        }
        ans.forEach(System.out::println);//added for following the result in console, but you can remove this line
        return ans;
    }
}
