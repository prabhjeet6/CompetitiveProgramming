package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/solutions/971810/java-binary-search-and-prefix-sum-with-comments/
public class MaximumSideSquareSubMatrix {
    public static void main(String[] as) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //gives prefixSum of matrix with each cell representing  rightmost bottom cell with (0,0)
        // representing left-top cell

        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int threshold = Integer.parseInt(bufferedReader.readLine());
            //Given  m x n matrix mat and an integer threshold, return the maximum side-length
            // of a square with a sum less than or equal to threshold or return 0 if there is no
            // such square.

            solve(matrix, prefixSum, m, n, threshold);

        }

    }

    static void solve(int[][] matrix, int[][] prefixSum, int m, int n, int threshold) {
        //Use binary Search to find max side length of a square with a sum less than or equal to
        // threshold
        //square will reside in matrix hence high is min of m,n, that is, max length of square can be
        // min(m,n)
        int sideLen = 0, low = 0, high = Math.min(m, n);
        while (low <= high) {
            //prevents overflow
            //find a mid-value to represent square sideLength
            sideLen = low + (high - low) / 2;
            int maxSumOfSquareLessThanOrEqualToThreshold = Integer.MAX_VALUE;
            //add sideLen to each cell index to check if it exists in the rectangle, and if so,
            // use prefixSum to calc its sum
            for (int i = 1; i + sideLen <= m; i++) {
                for (int j = 1; j + sideLen <= n; j++) {
                    //Add prefixSum[i + sideLen][j + sideLen] as bottom right cell representing sum of matrix
                    // from (0,0) to prefixSum[i + sideLen][j + sideLen]
                    //subtract sub-matrix in the left of square being considered, if any
                    //subtract sub-matrix at the top of square being considered, if any
                    //Add prefixSum[i - 1][j - 1] as this area is subtracted twice by above two operations
                    int subMatrixSum = prefixSum[i + sideLen][j + sideLen] - prefixSum[i + sideLen][j - 1]
                            - prefixSum[i - 1][j + sideLen] + prefixSum[i - 1][j - 1];
                    if (subMatrixSum < maxSumOfSquareLessThanOrEqualToThreshold) {
                        //find minimum possible square sum for 'sideLen'
                        maxSumOfSquareLessThanOrEqualToThreshold = subMatrixSum;
                    }
                }
            }
            //if it is more than threshold,move high to the left of mid
            //move left to right of mid(sideLen) otherwise
            //return low when loop breaks
            if (maxSumOfSquareLessThanOrEqualToThreshold > threshold) {
                high = sideLen - 1;
            } else {
                low = sideLen + 1;
            }
        }
        System.out.println(low);
    }

}