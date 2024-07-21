package gfg;


import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] asd) {
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRodBottomTopDP(price, 8));
        //The maximum obtainable value is
        //24 by cutting the rod into 8 pieces
        //of length 1, i.e, 8*price[1]= 8*3 = 24.
    }


    // n denotes size of rod

    //Recursive-BruteForce
    //TC: O(N^N) SC:O(1)
    public static int cutRodRecursive(int[] price, int n) {
        if (n <= 0) {
            return 0;
        }
        //ans needs to be marked zero for every recursive call so that it can be compared with its previous values, otherwise, all the values will
        // be accumulated and ultimately be stored in ans, instead of storing the most optimal value
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, price[i - 1] + cutRodRecursive(price, n - i));
        }
        return ans;

    }


    //Top-Bottom DP

    public static int cutRodTopBottomDP(int[] price, int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        return solve(price, n, ans);

    }

    static int solve(int[] price, int n, int[] ans) {
        if (n <= 0) {
            return 0;
        }
        if (ans[n] != -1) {
            return ans[n];
        }
        for (int j = 1; j <= n; j++) {
            ans[n] = Math.max(ans[n], price[j - 1] + solve(price, n - j, ans));
        }
        return ans[n];

    }

    //Bottom-Top DP
    //TC:O(N^2) SC:O(N)
    public static int cutRodBottomTopDP(int[] price, int n) {
        int[] ans = new int[n + 1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                ans[i]=Math.max(ans[i],price[j-1]+ans[i-j]);
            }
        }
        return ans[n];

    }

}

