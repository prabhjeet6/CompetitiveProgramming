package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixBlockSum {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String mnk[] = bufferedReader.readLine().split(" ");
		int m = Integer.parseInt(mnk[0]);
		int n = Integer.parseInt(mnk[1]);
		int k = Integer.parseInt(mnk[2]);
		long arr[][] = new long[m][n];
		for (int i = 0; i < m; i++) {
			String row[] = bufferedReader.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Long.parseLong(row[j]);
			}
		}
		// row-wise PrefixSum
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				arr[i][j] += arr[i][j - 1];
			}
		}

		// column-wise PrefixSum
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] += arr[i - 1][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				/***
				 * As the problem mentions below, we need to calculate r and c for each varying
				 * value of i and j, and then calculate their lower and upper bounds to find the
				 * sum to be printed for the resultant matrix.
				 * 
				 * 
				 * Given a m x n matrix mat and an integer k, print a matrix answer where each
				 * answer[i][j] is the sum of all elements mat[r][c] for:
				 * 
				 * i - k <= r <= i + k, j - k <= c <= j + k, and (r, c) is a valid position in
				 * the matrix.
				 */

				int i1 = i - k < 0 ? 0 : i - k;
				int j1 = j - k < 0 ? 0 : j - k;
				int i2 = i + k > m - 1 ? m - 1 : i + k;
				int j2 = j + k > n - 1 ? n - 1 : j + k;
				System.out.print(calcMatrixBlockSum(arr, i1, j1, i2, j2) + " ");
			}
			System.out.println();
		}

	}

	private static long calcMatrixBlockSum(long arr[][], int i1, int j1, int i2, int j2) {
		long sub1 = j1 == 0 ? 0 : arr[i2][j1 - 1];
		long sub2 = i1 == 0 ? 0 : arr[i1 - 1][j2];
		long add = i1 == 0 || j1 == 0 ? 0 : arr[i1 - 1][j1 - 1];
		return arr[i2][j2] - sub1 - sub2 + add;

	}
}
