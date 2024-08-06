package leetcode;

import java.util.Arrays;

class LongestCommonSubsequence {
    public static void main(String as[]) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    int[][] ans;

    public int longestCommonSubsequence(String text1, String text2) {
        //BruteForce: Recursive TC: O(2^N)
        //return solveRecursive(text1, text2, text1.length() - 1, text2.length() - 1);


        //Top Down DP: TC:O(N*M) SC:O(N*M)
        /* ans = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(ans[i],-1);
        }
        return solveTopDownDP(text1, text2, text1.length() - 1, text2.length() - 1);*/

        //BottomTop DP: SC:O(N*M) TC:O(N*M)
        //By default, all cells are initialized to zero. otherwise, explicitly marking top row and left column
        // to zero is needed to indicate base case of negative indices.
        // for Bottom Up approach, increasing length and breath of ans matrix to accommodate for negative indices.
        ans = new int[text1.length() + 1][text2.length() + 1];
        return solveBottomTopDP(text1, text2);
    }

    int solveRecursive(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            //characters match, check further
            return 1 + solveRecursive(text1, text2, i - 1, j - 1);
        } else {
            //characters do not match,compare for the longest common subsequence
            //solveRecursive(text1, text2, i - 1, j) take 'i', do not take 'j'
            //solveRecursive(text1, text2, i , j-1) take 'j', do not take 'i'
            return Math.max(solveRecursive(text1, text2, i - 1, j), solveRecursive(text1, text2, i, j - 1));
        }
    }

    int solveTopDownDP(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (ans[i][j] != -1) {
            return ans[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            //characters match, check further
            ans[i][j] = 1 + solveTopDownDP(text1, text2, i - 1, j - 1);
        } else {
            //characters do not match,compare for the longest common subsequence
            //solveTopDownDP(text1, text2, i - 1, j) take 'i', do not take 'j'
            //solveTopDownDP(text1, text2, i , j-1) take 'j', do not take 'i'
            ans[i][j] = Math.max(solveTopDownDP(text1, text2, i - 1, j), solveTopDownDP(text1, text2, i, j - 1));
        }
        return ans[i][j];
    }

    int solveBottomTopDP(String text1, String text2) {
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                //'ans' Matrix needs to be filled in Level order because each cell depends upon either its previous cell
                // to the left(i,j-1) or cell above it(i-1,j) and cell next to the cell above(i-1,j-1)
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //characters match, check further
                    ans[i][j] = 1 + ans[i - 1][j - 1];
                } else {
                    ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]);
                }
            }
        }
        return ans[text1.length()][text2.length()];
    }
}