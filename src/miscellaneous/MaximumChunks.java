package miscellaneous;

import java.util.Scanner;
import java.util.stream.Stream;

/***
 * You are given an integer array of length n that represents a permutation of
 * the integers in the range [ 0 , n-1 ] .
 * 
 * We split a r r into some number of chunks (i.e., partitions), and
 * individually sort each chunk. After concatenating them, the result should
 * equal the sorted array.
 * 
 * Print the largest number of chunks we can make to sort the array
 * 
 * First line of input contains an integer n Next line of input contains n space
 * separated integers a 1 , a 2 , a 3 ...., a n ( 0 <=a [ i ]<=n-1 ). All the
 * numbers are unique
 * 
 * Input: Arr[5] = { 1, 2, 0, 3, 4 } Output: 3
 * 
 */
public class MaximumChunks {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		long numberOfIntegers = Long.parseLong(s.nextLine());
		String inputPermutation[] = s.nextLine().split(" ");

		long[] permutationOfIntegers = Stream.of(inputPermutation).mapToLong(Long::parseLong).toArray();

		Long prefixMax[] = new Long[(int) numberOfIntegers];
		prefixMax[0] = permutationOfIntegers[0];
		for (int i = 1; i < numberOfIntegers; i++) {
			prefixMax[i] = prefixMax[i - 1] > permutationOfIntegers[i] ? prefixMax[i - 1] : permutationOfIntegers[i];
		}

		long maxChunks = 0L;
		for (int i = 0; i < numberOfIntegers ; i++) {
            if(prefixMax[i]==i) {
            	maxChunks++;
            }
		}
		System.out.println(maxChunks);

	}

}
