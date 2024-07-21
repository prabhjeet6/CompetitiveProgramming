package gfg;

import java.util.Arrays;

public class CuttingSegments {

    public static void main(String[] asd) {
        System.out.println(maximizeBottomTopDP(4, 2, 1, 1));
        System.out.println(maximizeBottomTopDP(5, 5, 3, 2));
    }

    //Time complexity : O(3^n) for n length line . As we are making three function calls from each function calls.
    //Space complexity : O(n) recursion stack space.
    public static int maximizeCutsRecursive(int n, int x, int y, int z) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        int ansX = maximizeCutsRecursive(n - x, x, y, z);
        int ansY = maximizeCutsRecursive(n - y, x, y, z);
        int ansZ = maximizeCutsRecursive(n - z, x, y, z);

        int totalCuts = Math.max(ansZ, Math.max(ansX, ansY));

        if (totalCuts == -1) {
            return -1;
        }
        // if we make a single cut, then, it will produce two pieces; if we make two cuts, then,
        // it will produce three pieces and so on
        return totalCuts + 1;
    }

    //Time Complexity: O(N) since each subProblem is solved only once.
    //Space Complexity: O(N) due to the memoization table used to store the maximum number of cuts for line segments of different lengths
    public static int maximizeCutsTopDownDP(int n, int x, int y, int z) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MIN_VALUE);
        int res = solveTopDownDP(n, x, y, z, ans);
        return res == -1 ? 0 : res;

    }

    private static int solveTopDownDP(int n, int x, int y, int z, int[] ans) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (ans[n] != Integer.MIN_VALUE) {
            return ans[n];
        }
        int ansX = solveTopDownDP(n - x, x, y, z, ans);
        int ansY = solveTopDownDP(n - y, x, y, z, ans);
        int ansZ = solveTopDownDP(n - z, x, y, z, ans);

        int totalCuts = Math.max(ansZ, Math.max(ansX, ansY));

        if (totalCuts == -1) {
            ans[n] = -1;
            return ans[n];
        }
        // if we make a single cut, then, it will produce two pieces; if we make two cuts, then,
        // it will produce three pieces and so on
        ans[n] = totalCuts + 1;
        return ans[n];
    }

    public static int maximizeBottomTopDP(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i <= n; i++) {
            if (i == x || i == y || i == z) {
                dp[i]= 1;
            }
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }

        }
    return dp[n]==-1?0:dp[n];
    }
}