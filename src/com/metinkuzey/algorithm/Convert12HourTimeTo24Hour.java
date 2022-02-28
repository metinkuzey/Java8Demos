package com.metinkuzey.algorithm;

import java.io.*;

public class Convert12HourTimeTo24Hour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Documents\\output.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();
        String result = timeConversion(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
    public static String timeConversion(String time){
        if(time.contains("PM")){
            if(!time.substring(0, 2).equals("12")){
                time = (Integer.parseInt(time.substring(0,2))+12) + time.substring(2,8);
            }else{
                time = time.substring(0, 8);
            }
        }else if(time.substring(0,2).equals("12") && time.substring(8,10).equals("AM")){
            time = "00" + time.substring(2, 8);

        }else{
            time = time.substring(0, 8);
        }
        return time;
    }
}
