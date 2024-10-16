package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindMaxRemovalsFromSourceString {
    char[] s, t;
    int n, m;
    Set<Integer> set;
    int max = (int)1e9;
    int[][] dp;
    int lcs(int i, int j) {
        if(i == n) {
            //if source and pattern indices reach at end, return 0
            //if source index reaches at end, but, pattern does not,
            // return max, as this will eventually be compared to a lower value
            if(j == m) return 0;
            return max;
        }
        //if pattern reaches last index
        if(j == m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ta = max, l = max;
        if(s[i] == t[j]) {
            if(set.contains(i)) {
                //if source and pattern character mach and index is part of target Indices
                // take the index in total characters to be removed
                ta = 1 + lcs(i + 1, j + 1);
            }
            //else do not take, increase source and pattern indices
            else ta = lcs(i + 1, j + 1);
        }
        //do not take, increase index of source, but, do not increase pattern's index for further check
        l = lcs(i + 1, j);
        //compare and take the lower value
        return dp[i][j] = Math.min(ta, l);
    }
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        s = source.toCharArray(); t = pattern.toCharArray();
        n = s.length; m = t.length;
        set = new HashSet<>();
        for(int x : targetIndices) set.add(x);
        dp = new int[n][m];
        for(int[] a : dp) Arrays.fill(a, -1);
        int x = lcs(0, 0);

        return targetIndices.length - x;
    }
}