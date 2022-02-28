package com.metinkuzey.algorithm;

import java.io.*;
import java.util.stream.IntStream;

public class HexagonalGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Documents\\output.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                String a = bufferedReader.readLine();
                String b = bufferedReader.readLine();
                String result = hexagonalGrid(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
/**
    You are given a hexagonal grid consisting of two rows, each row consisting of n cells.
    The cells of the first row are labelled a1,a2,a3,....an and
    the cells of the second row are labelled b1,b2,b3,....bn.

    For example, for n = 6;

          /\  /\  /\  /\  /\  /\
         |a1||a2||a3||a4||a5||a6|
          \/  \/  \/  \/  \/  \/
           |b1||b2||b3||b4||b5||b6|
            \/  \/  \/  \/  \/  \/

 Note that bi is connected with ai+1

     /\            /\
    |  |          |  |          /\ /\
     \/\          /\/          |  |  |
     |  |        |  |           \/ \/
      \/          \/

    As you can see above, there are three possible orientations in which a tile can be placed.
    Your goal is to tile the whole grid such that every cell is covered by a tile, and no two tiles occupy the same cell. To add to the woes, certain cells of the hexagonal grid are blackened. No tile must occupy a blackened cell.

    Is it possible to tile the grid?

    Here's an example. Suppose we want to tile this grid:
              /\  /\  /\  /\  /\  /\
             |a1||||||a3||a4||a5||a6|
              \/  \/  \/  \/  \/  \/
               |b1||b2||b3||b4||||||b6|
                \/  \/  \/  \/  \/  \/
    Then we can do the tiling as follows:
             /\  /\  /\  /\  /\  /\
            |  ||||||  ||  ||  ||  |
             \/  \/  \/  \/  \/  \/
              |  ||  ||  ||  ||||||  |
               \/  \/  \/  \/  \/  \/
**/
public static String hexagonalGrid(String a, String b) {
    long countArrayAOnes = a.chars().filter(ch -> ch == '1').count();
    long countArrayBOnes = b.chars().filter(ch -> ch == '1').count();
    if (Long.sum(countArrayAOnes, countArrayBOnes) % 2 != 0)
        return "NO";
    char[] array1 = a.toCharArray();
    char[] array2 = b.toCharArray();
    boolean block = false;
    int white = 0;
    for (int i = 0; i < array1.length; i++) {
        if (array1[i] == '1') {
            if (block && white % 2 != 0)
                return "NO";
            block = true;
        } else if (array1[i] == '0') {
            block = false;
            white += 1;
        }
        if (array2[i] == '1') {
            if (block && white % 2 != 0)
                return "NO";
            block = true;
        } else if (array2[i] == '0') {
            block = false;
            white += 1;
        }
    }
    return "YES";
}
}
