package leetcode.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than n / 2 times. You
 * may assume that the majority element always exists in the array.
 * 
 * NOTE : Solve the problem in linear time and in O(1) space?
 * 
 * Input Format
 * 
 * First line of input contains an integer N , the size of the array Second-line
 * contains N space-separated integers describing elements of the array Output
 * Format
 * 
 * Print the element which occurs more than N/2 times . Constraints:
 * 
 * 1 <= N <= 100 1 <=n u m s [ i ] <=100
 * 
 * Sample Input 0
 * 
 * 5
 * 
 * 1 2 1 2 1
 * 
 * Sample Output 0
 * 
 * 1
 */
//https://leetcode.com/problems/majority-element/submissions/1448630805/
public class MajorityElement1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int[] nums = new int[N];
		nums = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		int count = 0,lastIndex=nums.length - 1,totalElements=nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (totalElements == 1) {
				System.out.println(nums[0]);
				return;
			}
			if (i != lastIndex && nums[i] == nums[i + 1]) {
				count++;
			} else if (i == lastIndex && nums[i] == nums[i - 1]) {
				count++;
				if (count > totalElements / 2) {
					System.out.println(nums[i]);
					return;
				} 
			}
			else if ((i != lastIndex && nums[i] != nums[i + 1])) {
				count++;
				if (count > totalElements / 2) {
					System.out.println(nums[i]);
					return;
				}
			}
		}
	}

}
