package leetcode;

//https://leetcode.com/problems/maximize-total-cost-of-alternating-subarrays/
//https://www.youtube.com/watch?v=YQ-pmlVA6nA

import java.math.*;

class MaximizeTotalCostOfAlternatingSubArrays {

    //dp array is taken with length n+1 to accommodate lower bound ArrayIndexOutOfBoundsException inside the loop

    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            long option1 = dp[i] + nums[i];
            long option2 = dp[i - 1] + nums[i - 1] + nums[i] * (-1l);
            dp[i + 1] = Math.max(option1, option2);

        }
        return dp[n];
    }
}