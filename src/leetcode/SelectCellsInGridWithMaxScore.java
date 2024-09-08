package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SelectCellsInGridWithMaxScore {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[] dp = new int[m + 1];
        //for(int i=0;i<m;i++){
        Arrays.fill(dp, -1);
        // }
        dp[0] = 0;
        Set<Integer> set = new HashSet<>();
        recurse(grid, dp, set, m, n, 1);
        return dp[m];
    }

    //int ans;
    void recurse(List<List<Integer>> grid, int[] dp, Set<Integer> set, int m, int n, int i) {
        //base condition
        if (i == m + 1 || set.size() == m) {
            return;
        }
        if (dp[i] != -1) {
            return;
        }
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for (int idx = m - 1; idx >= 0; idx--) {
            for (int j = 0; j < n; j++) {
                int num = grid.get(idx).get(j);
                if (num > max && !set.contains(num)) {
                    max = num;
                    prev = max;
                    //System.out.println(max);
                }
            }
            if (max < 0) {
                max = prev;
            }
            System.out.println(max + " " + prev);

            set.add(max);
            dp[i] = dp[i - 1] + max;

            recurse(grid, dp, set, m, n, i + 1);
        }
    }
}

