package miscellaneous;

import java.util.*;
import java.lang.*;

public class BooleanMatrix {
    /**
     * Approach:
     * <p>
     * Using a temporary array - We can create a temporary array and traverse the original array while reflecting
     * the changes on the temporary array. We can then copy the temporary array on the original array.
     * Time complexity: O(M*N(M+N)) = O(N3)  (For M=N)
     * Space complexity: O(M*N)
     * <p>
     * Preprocessing: Since we have to make all the cells of ith row and jth column as 1 when mat[i][j]=1. Thus,
     * we can store all the row and column indices as a pre-processing step. We can then modify the original array
     * accordingly.
     * Time complexity: O(M*N)
     * Space complexity: O(M+N)
     * <p>
     * Note: Lookups in arrays are faster than maps.
     */
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            long arr[][] = new long[row][col];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            long result[][] = transformBooleanMatrix(arr);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            test--;
        }
    }

    public static long[][] transformBooleanMatrix(long arr[][]) {
        long row[] = new long[arr.length];
        long col[] = new long[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 1;
                }
            }
        }
        return arr;
    }
}





