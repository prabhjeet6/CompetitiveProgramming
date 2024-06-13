package miscellaneous; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class InversionCount {
    static void totalInversionsBruteForce(Long a[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String input[] = bufferedReader.readLine().split(" ");
            long a[] = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = Long.parseLong(input[j]);
            }
            //totalInversionsBruteForce(a, n);

            long count = mergesort(a, 0, n - 1);
            System.out.println(count);
        }

    }

    public static long mergesort(long arr[], int s, int e) {
        if (s >= e)
            return 0;

        int m = (s + e) / 2;
        long count = 0;
        count += mergesort(arr, s, m);
        count += mergesort(arr, m + 1, e);
        count += merge(arr, s, m, e);
        return count;
    }

    public static long merge(long arr[], int s, int m, int e) {
        long count = 0;
        int n1 = m - s + 1;
        int n2 = e - m;

        long L[] = new long[n1];
        long R[] = new long[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[s + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                count += n1 - i; // Count inversions
            }
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];

        return count;
    }

}