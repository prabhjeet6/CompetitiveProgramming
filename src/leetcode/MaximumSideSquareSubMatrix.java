package leetcode;

//https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/solutions/971810/java-binary-search-and-prefix-sum-with-comments/
public class MaximumSideSquareSubMatrix {
    public static void main(String[] a) {
        int ans = maxSideLength(new int[][]{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}}, 4);
        System.out.println(ans);
    }

    static public int maxSideLength(int[][] matrix, int threshold) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        //Use binary Search to find max side length of a square with a sum less than or equal to
        // threshold
        //square will reside in matrix hence high is min of m,n, that is, max length of square can be
        // min(m,n)
        int sideLen = 0, low = 0, high = Math.min(m, n), ans = 0;
        while (low <= high) {
            //prevents overflow
            //find a mid-value to represent square sideLength
            sideLen = low + (high - low) / 2;
            if (isFeasible(sideLen, prefixSum, threshold, m, n)) {
                boolean isFeasible = isFeasible(sideLen + 1, prefixSum, threshold, m, n);
                if (!isFeasible) {
                    ans = sideLen;
                    break;
                } else {
                    low = sideLen + 1;
                }
            } else {
                high = sideLen - 1;
            }
        }
        return ans;
    }

    static boolean isFeasible(int sideLen, int[][] prefixSum, int threshold, int m, int n) {
        //add sideLen to each cell index to check if it exists in the rectangle, and if so,
        // use prefixSum to calc its sum
        for (int i = 0; i + sideLen <= m; i++) {
            for (int j = 0; j + sideLen <= n; j++) {
                //Add prefixSum[i + sideLen][j + sideLen] as bottom right cell representing sum of matrix
                // from (0,0) to prefixSum[i + sideLen][j + sideLen]
                //subtract sub-matrix in the left of square being considered, if any
                //subtract sub-matrix at the top of square being considered, if any
                //Add prefixSum[i ][j ] as this area is subtracted twice by above two operations
                int subMatrixSum = prefixSum[i + sideLen][j + sideLen] - prefixSum[i + sideLen][j]
                        - prefixSum[i][j + sideLen] + prefixSum[i][j];
                if (subMatrixSum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxSideLength2(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        //padding for first row and column
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int low = 0, high = Math.min(m, n), sideLen = 0;

        while (low <= high) {
            sideLen = low + (high - low) / 2;
            int subSquareSum = Integer.MAX_VALUE;
            for (int i = 1; i + sideLen <= m; i++) {
                for (int j = 1; j + sideLen <= n; j++) {
                    int subSquareSumAtIndex = prefixSum[i + sideLen][j + sideLen]
                            - prefixSum[i + sideLen][j - 1]
                            - prefixSum[i - 1][j + sideLen]
                            + prefixSum[i - 1][j - 1];
                    if (subSquareSumAtIndex < subSquareSum) {
                        subSquareSum = subSquareSumAtIndex;
                    }
                }
            }
            if (subSquareSum > threshold) {
                high = sideLen - 1;
            } else {
                low = sideLen + 1;
            }
        }
        return low;

    }
}
