package miscellaneous;

import java.util.Scanner;
import java.util.stream.Stream;

/***
 * rotate an array by ‘k’ units clockwise using different methods. Input: Arr[6]
 * = { 1, 2, 3, 4, 5, 6 }, k = 3 O: Arr[6] = { 4, 5, 6, 1, 2, 3 }
 */
public class RotateTheArray {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String nAndK[] = s.nextLine().split(" ");
		long n = Long.parseLong(nAndK[0]);
		long k = Long.parseLong(nAndK[1]);

		long arr[] = Stream.of(s.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		// bruteForceImpl(arr, n, k);
		// usingTemporaryArray(arr, n, k);
		usingArrayReversal(arr, n, k);
	}

	private static void usingArrayReversal(long[] arr, long n, long k) {
		/*
		 * 17 clockwise moves for an array of 5 is equivalent to 2 clockwise moves in
		 * original array
		 */
		k = k % n;
		if (n == 1) {
			System.out.print(arr[0] + " ");
		} else {
			reverseArray(arr, 0, (int) (n - k - 1));
			reverseArray(arr, (int) (n - k), (int) (n - 1));
			reverseArray(arr, 0, (int) (n - 1));
			for (long i : arr)
				System.out.print(i + " ");
		}
	}

	/**
	 * 
	 * Brute Force - Rotate the array clockwise by 1 unit and repeat the steps ‘k’
	 * times. Time complexity: O(kN) Space complexity: O(1)
	 */
	static void bruteForceImpl(long arr[], long n, long k) {

		for (long j = 0; j < k; j++) {
			long x = arr[(int) (n - 1)];
			for (long i = n - 2; i >= 0; i--) {
				arr[(int) (i + 1)] = arr[(int) i];
			}
			arr[0] = x;

		}
		for (long i : arr)
			System.out.print(i + " ");
	}

	/***
	 * Using a temporary array - We can create a temporary array and store the
	 * elements at their new position after rotation. Time complexity: O(N) Space
	 * complexity: O(N)
	 */
	static void usingTemporaryArray(long arr[], long n, long k) {
		long temp[] = new long[(int) n];
		/*
		 * 17 clockwise moves for an array of 5 is equivalent to 2 clockwise moves in
		 * original array
		 */
		k = k%n;
		for (int i = 0; i < n; i++) {
			/*
			 * if i+equivalentMoves exceeds n, then using mod with n will give appropriate
			 * indices empty in temp array
			 */
			temp[i] = arr[(int) ((i + k) % n)];
		}
		arr = temp;
		for (long i : arr)
			System.out.print(i + " ");

	}

	static long[] reverseArray(long arr[], int start, int end) {
		while (start < end) {
			long temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}

}
