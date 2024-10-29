package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSideSquareSubMatrix {
    public static void main(String[] a) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //row-wise prefix sum
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        //col-wise prefix sum
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int threshold = Integer.parseInt(bufferedReader.readLine());
            //Print the maximum side-length of a square with a 'sum less than or equal to threshold'
            //or print 0 if there is no such square for each testcase

            //row and col sum together will give sub-matrix
            solve(matrix, m, n, threshold);
        }
    }

    static void solve(int[][] matrix, int m, int n, int threshold) {
        //Max length of square's side can be smaller of the length and breath of rectangle as square
        //has to be contained in the rectangle.
        //Binary Search on ans (max length of square with sum less than or equal to  )
        int low = 1, high = Math.min(m, n);
        while (low <= high) {
            //prevents overflow
            int mid = low + (high - low) / 2;
            if (isFeasible(matrix, m, n, threshold)) {
                //low will at least be mid(longest side of square with sum <=threshold)
                low = mid;
            } else {
                high = mid - 1;
            }
        }
    }

    static boolean isFeasible(int[][] matrix, int m, int n, int threshold) {
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matr)
            }
        }
        return false;
    }


}

