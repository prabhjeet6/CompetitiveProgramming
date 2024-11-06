package codeforces.arrays;

import java.util.Scanner;
import java.util.stream.Stream;

public class BAlonyaAndFlowers {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int maxHappiness = 0;
		String numberOfFlowersAndNumberOfSubArrays[] = s.nextLine().split(" ");
		int numberOfFlowers = Integer.parseInt(numberOfFlowersAndNumberOfSubArrays[0]);
		int numberOfSubArrays = Integer.parseInt(numberOfFlowersAndNumberOfSubArrays[1]);
		int[] flowerMood = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] prefixSum = new int[numberOfFlowers];
		prefixSum[0] = flowerMood[0];
		for (int i = 1; i < numberOfFlowers; i++) {
			prefixSum[i] = prefixSum[i - 1] + flowerMood[i];
		}
		for (int i = 0; i < numberOfSubArrays; i++) {
			int[] subArrayBounds = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			maxHappiness += calculateHappiness(flowerMood, subArrayBounds[0], subArrayBounds[1], prefixSum);
		}
		System.out.println(maxHappiness);

	}

	static int calculateHappiness(int[] flowerMood, int subArrayStartIndex, int subArrayEndIndex, int[] prefixSum) {
		if (subArrayEndIndex == subArrayStartIndex) {
			if (prefixSum[subArrayEndIndex - 1] > 0) {
				return prefixSum[subArrayEndIndex - 1];
			} else {
				return 0;
			}
		} else {
			if (subArrayStartIndex - 1 == 0) {
				if (prefixSum[subArrayEndIndex - 1] > 0) {
					return prefixSum[subArrayEndIndex - 1];
				} else {
					return 0;
				}
			} else {
				if (prefixSum[subArrayEndIndex - 1] - prefixSum[subArrayStartIndex - 2] > 0) {
					return prefixSum[subArrayEndIndex - 1] - prefixSum[subArrayStartIndex - 2];
				}
			}
		}
		return 0;

	}
}