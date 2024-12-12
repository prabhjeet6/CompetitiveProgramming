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

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                max = Math.max(max,i-map.get(count) );
            } else {
                map.put(count, i);
            }
        }
        return max;


    }
}
