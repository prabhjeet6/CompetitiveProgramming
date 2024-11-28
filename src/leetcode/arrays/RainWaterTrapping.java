package leetcode.arrays;

import java.util.Scanner;
import java.util.stream.Stream;

/***
 * Histogram Problem/ N Pillars TimeComplexity O(N) Space ComplexityO(N)
 * Technique: Precomputation
 */
public class RainWaterTrapping {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		long numberOfPillars = Long.parseLong(s.nextLine());
		String inputHeights[] = s.nextLine().split(" ");

		long[] pillarHeights = Stream.of(inputHeights).mapToLong(Long::parseLong).toArray();

		Long prefixMax[] = new Long[(int) numberOfPillars];
		prefixMax[0] = pillarHeights[0];
		for (int i = 1; i < numberOfPillars; i++) {
			long currentPillarHieght = pillarHeights[i];
			prefixMax[i] = prefixMax[i - 1] > currentPillarHieght ? prefixMax[i - 1] : currentPillarHieght;
		}
		Long suffixMax[] = new Long[(int) numberOfPillars];
		suffixMax[(int) (numberOfPillars - 1)] = pillarHeights[(int) (numberOfPillars - 1)];
		for (int i = (int) (numberOfPillars - 2); i >= 0; i--) {
			long currentPillarHieght = pillarHeights[i];
			suffixMax[i] = suffixMax[i + 1] > currentPillarHieght ? suffixMax[i + 1] : currentPillarHieght;
		}
		long waterTrapped = 0L;
		for (int i = 1; i < numberOfPillars - 1; i++) {
			long currentPillarHieght = pillarHeights[i];
			if (currentPillarHieght < prefixMax[i - 1] && currentPillarHieght < suffixMax[i + 1]) {
				waterTrapped += Math.min(prefixMax[i - 1], suffixMax[i + 1]) - currentPillarHieght;
			}
		}
		System.out.println(waterTrapped);

	}

}
