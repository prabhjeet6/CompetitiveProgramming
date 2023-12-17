package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/***
 * Four Divisors You are given an array A of N numbers, output the sum of
 * divisors of numbers in an array having exactly 4 divisors.
 * 
 * Input Format
 * 
 * The first line of the input contains a single integer T denoting the number
 * of test cases. The description of T test cases follows The first line of each
 * test case contains a single integer N The second line contains N
 * space-separated integers A [ 0 ] , A [ 1 ] , . . . , A [ N - 1 ] array
 * numbers
 */
public class FourDivisors {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			int arr[] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int sum = 0, result = 0;
			for (int j = 0; j < arr.length; j++) {
				int count = 0;
				int sqrt = 0;
				sqrt = (int) Math.sqrt(arr[j]);
				if (sqrt * sqrt != arr[j]) {
					// perfect square will have odd number of factors, but, we need numbers with
					// only 4 factors
					for (int k = 1; k <= (int) Math.sqrt(arr[j]); k++) {
						if (arr[j] % k == 0) {
							count++;
							sum += k + (arr[j] / k);
						}
					}
					if (count == 2) {
						result += sum;
					}
					count = 0;
					sum = 0;
				}
			}
			System.out.println(result);
		}

	}

}
