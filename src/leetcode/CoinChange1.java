package leetcode;

import java.util.Arrays;

public class CoinChange1 {

    public static void main(String as[]) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3));
        int[] coins3 = {1};
        System.out.println(coinChange(coins3, 0));
    }

    static int[] dp;

    public static int coinChange(int[] coins, int amount) {
        //Recursion
        //int ans = solveRecursive(coins, amount);
        //return ans == Integer.MAX_VALUE ? -1 : ans;

        //Top-Down DP
        //dp = new int[amount + 1];
        //Arrays.fill(dp, -1);
        //int ans = solveTopDownDP(coins, amount);
        //return ans == Integer.MAX_VALUE ? -1 : ans;

        //Bottom-Up DP
        return solveBottomUpDP(coins,amount);

    }

    //tabulation method (bottom-up approach)
    //TC = O(n*amount)
    //SC = O(amount)
    static int solveBottomUpDP(int[] coins, int amount) {
     int[] dp=new int[amount+1];
     Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
     for(int i=1;i<=amount;i++){
         for (int j=0;j<coins.length;j++){
             if(i-coins[j]>=0&&dp[i-coins[j]]!=Integer.MAX_VALUE){
                 dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
             }
         }
     }
     return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];


    }

    //TC = O(n*amount)
    //SC = O(amount)
    static int solveTopDownDP(int[] coins, int amount) {
        int minCoins = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        for (int i = 0; i < coins.length; i++) {
            int ans = solveTopDownDP(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        dp[amount] = minCoins;
        return dp[amount];
    }

    static int solveRecursive(int[] coins, int amount) {
        //minCoins initialized to max possible value to find minCoins for 'amount' at the end of the call.
        int minCoins = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            int ans = solveRecursive(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }
}
