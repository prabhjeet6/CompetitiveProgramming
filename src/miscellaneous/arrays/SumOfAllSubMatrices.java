package miscellaneous.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a matrix mat with n*m elements , you need to find the sum all sub
 * matrices of the given matrix. Since the sum could be very large print the sum
 * modulo 10^9 + 7 .
 * 
 * Input
 * 
 * First Line contains two integers n , m . Next n lines contains m elements for
 * the matrix
 * 
 * Output
 * 
 * Required sum of all sub matrices.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 2 2
 * 
 * 1 2
 * 
 * 3 4
 * 
 * Output:
 * 
 * 40
 **/
public class SumOfAllSubMatrices {
	public static void main(String args[]) throws NumberFormatException, IOException {
		// Start Using BufferedReader instead of Scanner class, as Scanner is slower in
		// comparison to BufferedReader as Scanner parses input data

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = reader.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		long arr[][] = new long[n][m];
		for (int i = 0; i < n; i++) {
			String row[] = reader.readLine().split(" ");
			for (int j = 0; j < m; j++) {

				arr[i][j] = Long.parseLong(row[j]);
			}
		}
		long k = (long) (Math.pow(10, 9) + 7);
		long sum = 0l;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// TopLeft=(i+1)*(j+1)
				long calc = ((i + 1) * (j + 1)) % k;
				// BottomRight=(n-i)*(m-)
				calc *= (((n - i) * (m - j)) % k) % k;
				calc *= ((arr[i][j]) % k) % k;
				sum = (sum + calc) % k;

			}
		}
		System.out.println((long) sum);
	}

}
