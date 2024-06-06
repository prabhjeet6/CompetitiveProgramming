package miscellaneous;


/* package codechef; // don't place package name! */

import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class KthSmallestInArrayBruteForce {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());
        long a[] = new long[(int)N];
        String arrayInput[]=bufferedReader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(arrayInput[i]);
        }
        long k = Long.parseLong(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int smaller = 0, equals= 0;
            for (int j = 0; j < N; j++) {
                if (a[j] < a[i]) {
                    smaller++;
                } else if (a[j] == a[i]) {
                    equals++;
                }
            }
            int total = smaller + equals;
            if (total >= k && smaller < k) {
                System.out.print(a[i]);
                return;
            }
        }
    }
}

