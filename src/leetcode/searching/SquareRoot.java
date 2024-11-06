package leetcode.searching;



/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class SquareRoot {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(bufferedReader.readLine().trim());
        long[] testCases = new long[(int) T];
        //int []res=new int[T];
        for (int i = 0; i < T; i++) {
            testCases[i] = Long.parseLong(bufferedReader.readLine().trim());

        }
        for (int i = 0; i < T; i++) {

            long l = 0l, h = testCases[i];

            while (l <= h) {
                long m = (l + h) / 2;
                if (m * m == testCases[i]) {
                    System.out.println(m);
                    break;
                } else if (m * m > testCases[i]) {
                    h = m - 1;
                } else {
                    if (m * m < testCases[i] && (m + 1) * (m + 1) > testCases[i]) {
                        System.out.println(m);
                        break;
                    } else {
                        l = m + 1;

                    }
                }
            }
        }
    }
}