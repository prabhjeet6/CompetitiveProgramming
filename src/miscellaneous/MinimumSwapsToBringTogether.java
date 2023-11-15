package miscellaneous;

import java.util.Scanner;

/***
 * Given an array arr of n positive integers and a number k. One can apply a
 * swap operation on the array any number of times, i.e choose any two index i
 * and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps
 * required to bring all the numbers less than or equal to k together, i.e. make
 * them a contiguous subarray.
 * 
 * Input Format
 * 
 * First line contains 2 integers n and k . Second line contains n array
 * elements.
 * 
 * Example 1
 * 
 * Input
 * 
 * 5 3
 * 
 * 2 1 5 6 3
 * 
 * Output
 * 
 * 1
 * 
 * Explanation
 * 
 * To bring elements 2, 1, 3 together, swap index 2 with 4 (0-based indexing),
 * i.e. element arr[2] = 5 with arr[4] = 3 such that final array will be- arr[]
 * = {2, 1, 3, 6, 5}
 * 
 * Constraints:
 * 
 * 1 <= n <= 10^5 1 <= arr[i] , k<= 10^ 7
 */
public class MinimumSwapsToBringTogether {
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		// Enter two numbers separated by a space or a comma
		s.useDelimiter("[\\s,]+");
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		getMininmumSwaps(arr, k);
	}

	private static void getMininmumSwaps(int[] arr, int k) {
		int countOfLegalElements = 0;
		// Find total legal Elements in the array.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				countOfLegalElements++;
			}
		}
		int maxLegalElements = 0;
		/* Find legal Elements in first window of size equivalent to
		 countOfLegalElements*/
		for (int i = 0; i < countOfLegalElements; i++) {
			if (arr[i] <= k) {
				maxLegalElements++;
			}
		}
		int countOfLegalElementsInWindow = maxLegalElements;
		for (int i = countOfLegalElements; i < arr.length; i++) {
			
			if (arr[i] <= k) {
				countOfLegalElementsInWindow++;
			}
			if (arr[i - countOfLegalElements] <= k) {
				countOfLegalElementsInWindow--;
			}
			if (countOfLegalElementsInWindow > maxLegalElements) {
				maxLegalElements = countOfLegalElementsInWindow;
			}
		}
		int minSwapsNeeded = countOfLegalElements - maxLegalElements;
		System.out.println(minSwapsNeeded);
	}

}
