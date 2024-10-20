package miscellaneous;


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class IndexOfExtraElement {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] big = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] small = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int i = 0;
        boolean found = false;
        for (i = 0; i < n - 1; i++) {
            if (big[i] != small[i]) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.print(i);
        } else {
            System.out.print(n - 1);
        }
    }
}