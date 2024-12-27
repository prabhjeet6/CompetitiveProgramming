package leetcode.queues;


//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubArrayWithAbsDiffLessOrEqLimit {
    public static void main(String[] as) {
        System.out.println(longestSubarrayUsingTwoPointers(new int[]{10, 1, 2, 4, 7, 2}, 5));//4
        System.out.println(longestSubarrayUsingTwoPointers(new int[]{8, 2, 4, 7}, 4));//2
        System.out.println(longestSubarrayUsingTwoPointers(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));//3
    }

    public static int longestSubarrayBruteForce(int[] nums, int limit) {
        int count = 0, max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((j + 1) < n && Math.abs(nums[j] - nums[j + 1]) <= limit) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(count, max);
            count = 0;
        }
        return limit == 0 ? max + 1 : max;
    }

    public static int longestSubarrayUsingTwoPointers(int[] nums, int limit) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, windowSize = 0, left = 0, right = 0, n = nums.length;
        boolean windowBreakFound = false;
        while (right < n) {
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);
            int diff = Math.abs(max - min);

            if (diff > limit) {
                windowSize = Math.max(windowSize, right - left);
                left++;
                right = left;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                windowBreakFound = true;
            } else {
                right++;
                windowBreakFound = false;
            }

        }
        if (!windowBreakFound && (right - left) > windowSize) {
            windowSize = right - left;
        }
        return windowSize;
    }
}
