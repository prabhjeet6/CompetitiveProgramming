package miscellaneous.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * Calculate the sum of the elements of matrix inside the rectangle defined by
 * its upper left corner (x1, y1) and lower right corner (x2, y2) for every
 * query.
 * 
 * Input Format
 * 
 * First line contains n and m (dimensions of matrix). Next n lines contains m
 * elements for the matrix. Third line contains q denoting number of queries.
 * Next q lines contains x1,y1,x2,y2 where (x1,y1) is the upper left corner of
 * defined matrix and (x2,y2) lower right corner.
 * 
 * Output Format
 * 
 * Print q lines each denoting sum of the defined rectangle.
 * 
 * Example 1;
 * 
 * Input
 * 
 * 3 3
 * 
 * 1 2 3
 * 
 * 4 5 6
 * 
 * 7 8 9
 * 
 * 2
 * 
 * 0 0 1 1
 * 
 * 1 0 2 2
 * 
 * Output
 * 
 * 12
 * 
 * 39
 * 
 * Explanation For first query elements we got are 1+2+4+5 = 12 For second query
 * elements are 4+5+6+7+8+9=39
 * 
 * Constraints
 * 
 * 1 <= m*n <= 10^6 -1000 <= matrix[i][j] <= 1000 0 <= x1 <= x2 < n 0 <= y1 <=
 * y2 < m Number of queries will not exceed 10^5.
 */
public class RangeSumQuery2DImmutable {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		long arr[][] = new long[n][m];
		for (int i = 0; i < n; i++) {
			String row[] = bufferedReader.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Long.parseLong(row[j]);
			}
		}
		// row-wise PrefixSum
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr[i][j] += arr[i][j - 1];
			}
		}

		// column-wise PrefixSum
		//Just think in terms of PrefixSum, and the concepts taught for problem solving., nothing different
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] += arr[i - 1][j];
			}
		}
		int q = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < q; i++) {
			String[] input = bufferedReader.readLine().split(" ");
			int i1 = Integer.parseInt(input[0]);
			int j1 = Integer.parseInt(input[1]);
			int i2 = Integer.parseInt(input[2]);
			int j2 = Integer.parseInt(input[3]);
			System.out.println(calcSubMatrixSum(arr, i1, j1, i2, j2));
		}
	}

	private static long calcSubMatrixSum(long arr[][], int i1, int j1, int i2, int j2) {
		long sub1 = j1 == 0 ? 0 : arr[i2][j1 - 1];
		long sub2 = i1 == 0 ? 0 : arr[i1 - 1][j2];
		long add = i1 == 0 || j1 == 0 ? 0 : arr[i1 - 1][j1 - 1];
		return arr[i2][j2] - sub1 - sub2 + add;

	}

}
