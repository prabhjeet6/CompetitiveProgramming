package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ContigiousArray {

    public static void main(String[] a) {
        int[] ar = new int[]{0, 1, 0, 1};
        System.out.println(Arrays.toString(ar));
        System.out.println(findMaxLengthBruteForce(ar));
    }

    //TC: O(N^2)
    //SC: O(N)
    public static int findMaxLengthBruteForce(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0, ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    //To find the maximum length of a contiguous subarray with an equal number of 0s and 1s,
    // we can use the concept of prefix sum. Whenever we encounter a 0, we decrement the sum by 1,
    // and whenever we encounter a 1, we increment the sum by 1. If the prefix sum at two indices is
    // the same, it means that the number of 0s and 1s between those two indices is the same.
    // We store these prefix sums along with their indices in a hash map. Then, for each prefix sum
    // encountered, we check if we have seen this sum before. If so, it means that the subarray between
    // the current index and the index where this sum was last encountered has an equal number of 0s and
    // 1s. We calculate the length of this subarray and update the maximum length accordingly.
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;


    }
}
