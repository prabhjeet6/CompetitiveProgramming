package leetcode.arrays;

import java.util.Scanner;
import java.util.stream.Stream;

//https://leetcode.com/problems/max-chunks-to-make-sorted/description/

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
