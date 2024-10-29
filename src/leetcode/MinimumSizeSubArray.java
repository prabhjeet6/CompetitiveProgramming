package leetcode;
//https://leetcode.com/problems/minimum-size-subarray-sum/description/


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class MinimumSizeSubArray {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = Integer.parseInt(bf.readLine());
        while (t > 0) {
            t--;
            int target = Integer.parseInt(bf.readLine().trim());
            //bruteForce(target, nums);
            minSizeSubArrayUsingBinarySearch(target, nums);

        }
    }

    static void minSizeSubArrayUsingBinarySearch(int target, int[] nums) {
        long[] preFixSum = new long[nums.length + 1];
        //When calculating the minimum subarray length with a sum greater than or equal to the target,
        // we need to check subarrays that might start at the very beginning of the array. By setting
        // prefixSum[0] to 0, we ensure that the prefix sum correctly accounts for subarrays starting
        // from index 0 up to any other index in the array. look at line 44 for clarity
        preFixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preFixSum[i] = preFixSum[i - 1] + nums[i - 1];
        }
        //nums:      2 3 1 2 4  3
        //prefixSum: 2 5 6 8 12 15
        //target:   7 4 16

        int minLen = preFixSum.length + 1;

        for (int i = preFixSum.length - 1; i >= 0; i--) {
            int index = binarySearch((preFixSum[i] + target), preFixSum);
            if (index != -1) {
                minLen = Math.min(index - i, minLen);
            }
        }
        if (minLen == preFixSum.length + 1) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }

    //Apart from the binary Search approach used here, another  approach of binary search
    // could be to do binary search on answer(length of subArray could range from 0 to nums.length)
    //Each time , we find mid, we need to check, if prefixSum[i+mid-1] is greater than or equal to
    //target,find the least amongst those which qualify
    static int binarySearch(long target, long[] nums) {

        int low = 0, high = nums.length - 1, mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static void bruteForce(int target, int[] nums) {
        int minLen = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (minLen == nums.length + 1) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }
}
