package codeforces;


import java.io.*;
import java.util.*;

//https://codeforces.com/contest/1365
public class TroubleSort {
    public static void main(String[] as) throws Exception {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] a = new int[n];
            a = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] type = new int[n];
            type = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            boolean isSorted = true;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    isSorted = false;
                    break;
                }
            }
            // if array is sorted already, then we can print yes and continue to next test case
            if (isSorted) {
                System.out.println("Yes");
                continue;
            }
            int zeroCount = 0, oneCount = 0;
            for (int i = 0; i < n; i++) {
                if (type[i] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            //if we have at least one zero and one 1 in type array,
            // then we can sort the array using it
            if (zeroCount > 0 && oneCount > 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}