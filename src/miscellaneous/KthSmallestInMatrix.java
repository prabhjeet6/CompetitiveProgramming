package miscellaneous;


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class KthSmallestInMatrix {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Long a[][] = new Long[N][N];
        for (int i = 0; i < N; i++) {
            String row[] = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                a[i][j] = Long.parseLong(row[j]);
            }
        }
        int k = Integer.parseInt(bufferedReader.readLine());
        Long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (a[i][0] < min) {
                min = a[i][0];
            }
            if (a[i][N - 1] > max) {
                max = a[i][N - 1];
            }
        }

        binarySearchOnMatrix(min, max, a, k, N);
    }

    static void binarySearchOnMatrix(Long low, Long high, Long a[][], int k, int N) {
        int ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            int rankOfMid = monotonicFunction(a, low, high, N, mid, k);
            //   System.out.print(rankOfMid+" ");
            //  System.out.println(mid);
            if (rankOfMid < k) {
                low = mid + 1;
            } else {
                ans = (int) mid;
                high = mid - 1;

            }
        }
        System.out.println(ans);
    }

    static int monotonicFunction(Long a[][], Long low, Long high, int N, long mid, int k) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += binarySearchOnRow(a[i], k, N, mid);
        }
        return res;
    }

    //
    static int binarySearchOnRow(Long a[], int k, int N, long mid) {
        int l = 0, h = N - 1, m = 0, idx = -1;

        while (l <= h) {
            m = (l + h) / 2;
            if (mid >= a[m]) {
                idx = m;
                l = m + 1;
            } else {

                h = m - 1;

            }
        }
        return idx + 1;
    }
}