package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Solution5 {

	// Complete the diagonalDifference function below.
	static int diagonalDifference(int[][] arr, int n) {
		int left_diagonal_sum = 0;
		int right_diagonal_sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					left_diagonal_sum += arr[i][j];
				if (i + j == n - 1)
					right_diagonal_sum += arr[i][j];
			}
		}
		return Math.abs(left_diagonal_sum - right_diagonal_sum);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < n; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = diagonalDifference(arr, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
