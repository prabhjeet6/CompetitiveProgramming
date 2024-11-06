package miscellaneous.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Given an integer array nums, print the maximum difference between two
 * successive elements in its sorted form. If the array contains less than two
 * elements, print 0.
 * 
 * You must write an algorithm that runs in linear time and uses linear extra
 * space.
 * 
 * Input Format
 * 
 * First-line will contain T, number of test cases. Each test cases contains an
 * integer N, the size of the array and N space-separated integers describing
 * elements of the array. Output Format
 * 
 * Print the maximum difference between two successive elements in its sorted
 * form for each test cases in new line. Input 1: 2 4 3 6 9 1 3 2 6 1 Output 1:
 * 
 * 3 4 Constraints:
 * 
 * 1 <= T <= 5 1 <= n u m s . l e n g t h <= 10 5 0 <= n u m s [ i ] <= 10 9
 * Example Input 2
 */
public class MaximumGap {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			int nums[] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.out.println(calcMaxGap(nums));
		}
	}

	private static int calcMaxGap(int[] nums) {
		Arrays.sort(nums);
		if (nums.length < 2) {
			return 0;
		} else {
			int max_gap = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				if (i + 1 != nums.length && max_gap < nums[i + 1] - nums[i]) {
					max_gap = nums[i + 1] - nums[i];
				}
			}

			return max_gap;
		}

	}

	/*
	 * private static int calcMaxGapBucketization(int[] nums) { if (nums.length < 2)
	 * { return 0; } int max_num = Integer.MIN_VALUE, min_num = Integer.MAX_VALUE;
	 * for (int i = 0; i < nums.length; i++) { max_num = nums[i] > max_num ? nums[i]
	 * : max_num; min_num = nums[i] > min_num ? min_num : nums[i]; } if (max_num ==
	 * min_num) { return 0; } int gap = (max_num - min_num) % (nums.length - 1) == 0
	 * ? (max_num - min_num) / (nums.length - 1) : ((max_num - min_num) /
	 * (nums.length - 1)) + 1; int minNums[] = new int[nums.length], maxNums[] = new
	 * int[nums.length]; for (int i = 0; i < nums.length; i++) { minNums[i] =
	 * Integer.MAX_VALUE; maxNums[i] = Integer.MIN_VALUE; } for (int i = 0; i <
	 * nums.length - 1; i++) { int bucket = nums[i] - min_num / gap; minNums[bucket]
	 * = nums[i] < minNums[i] ? nums[i] : minNums[i]; maxNums[bucket] = nums[i] >
	 * maxNums[i] ? nums[i] : maxNums[i]; int prev=Integer.MIN_VALUE; int
	 * ans=Integer.MIN_VALUE; for(int j=0;j<nums.length;j++) {
	 * if(minNums[j]==Integer.MAX_VALUE) continue; if(prev==Integer.MIN_VALUE)
	 * prev=maxNums[j]; else { ans=ans>(minNums[j]-prev)?ans:(minNums[j]-prev);
	 * prev=maxNums[j]; } } return ans; }
	 * 
	 * }
	 */
}