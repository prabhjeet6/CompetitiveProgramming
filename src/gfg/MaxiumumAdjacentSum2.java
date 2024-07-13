package gfg;

import java.util.Arrays;

public class MaxiumumAdjacentSum2 {
    static int maxSum(int N, int[][] mat) {
        int ans[] = new int[N];
        Arrays.fill(ans, -1);
        return solve(N, mat, ans, 0);
    }

    static int solve(int N, int[][] mat, int[] ans, int i) {
        if (i >= N) {
            return 0;
        }
        if (ans[i] != -1) {
            return ans[i];
        }
        int take = Math.max(mat[0][i], mat[1][i]) + solve(N, mat, ans, i + 2);
        int doNotTake = solve(N, mat, ans, i + 1);
        ans[i] = Math.max(take, doNotTake);
        return ans[i];
    }

    public static void main(String args[]) {
        //2xN matrix
        int[][] mat = {{1, 4,5}, {2, 0,0}};
        System.out.println(maxSum(3, mat));
    }

}
