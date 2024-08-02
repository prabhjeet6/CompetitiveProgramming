package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-ii/description/
public class CoinChange2 {
    public static void main(String[] asd) {
        int[] coins = {1, 2, 3};
        System.out.println(count(coins, 3, 4));
    }

    static long[][] ans;

    public static long count(int[] coins, int N, int sum) {
        //Recursive
        //return solveRecursive(coins, N, sum, coins.length - 1);

        //Top Down
       /* ans = new long[sum + 1][N];

        for (int i = 0; i <= sum; i++) {
            Arrays.fill(ans[i], -1);
        }
        return solveTopDownDP(coins, N, sum, coins.length - 1);*/

        //Bottom Up
        return countBottomTop(coins, N, sum);
    }

    static long solveTopDownDP(int[] coins, int N, int sum, int idx) {
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if (idx < 0) {
            return 0;
        }
        if (ans[sum][idx] != 0) {
            return ans[sum][idx];
        }
        //took coins[idx] and stood on same idx to decide if it was to be taken further
        ans[sum][idx] = solveTopDownDP(coins, N, sum - coins[idx], idx) +
                //didn't take coins[idx] and moved to next idx
                solveTopDownDP(coins, N, sum, idx - 1);
        return ans[sum][idx];
    }


    static long solveRecursive(int coins[], int N, int sum, int idx) {
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if (idx < 0) {
            return 0;
        }
        return solveRecursive(coins, N, sum - coins[idx], idx) + solveRecursive(coins, N, sum, idx - 1);
    }

    //Refer to Notes
    static long countBottomTop(int[] coins, int N, int sum) {
        long[][] dp = new long[coins.length + 1][sum + 1];
        //base case:In topdown DP, amount=0, corresponds to returning 1
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        //base case:In topdown DP, negative index, corresponds to returning 0; pls note dp matrix has additional
        // row and column
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][sum];
    }
}
