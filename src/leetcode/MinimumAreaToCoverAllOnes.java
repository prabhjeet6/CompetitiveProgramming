package leetcode;
//https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/
//https://www.youtube.com/watch?v=YQ-pmlVA6nA

/* Approach: find the first column that has a 1 and last column that has a 1, difference between them will give you
 *  breadth. Similarly, find the first row that has a 1 and last row that has a 1, this will give you length.
 *  Product of length and breadth will give you the desired area*/

public class MinimumAreaToCoverAllOnes {
    public static void main(String arg[]) {
        //int[][] grid = {{0, 0}, {1, 0}};
        int [][]grid={{0,1,0},{1,0,1}};
        System.out.print(minimumArea(grid));
    }

    public static int minimumArea(int[][] grid) {
        int n = grid.length;//length :represents rows
        int m = grid[0].length;//breadth :represents columns
        int top = -1;
        int bottom = -1;
        int left = -1;
        int right = -1;
        /* Approach: find the first column that has a 1 and last column that has a 1, difference between them will give you
         *  breadth. Similarly, find the first row that has a 1 and last row that has a 1, this will give you length.
         *  Product of length and breadth will give you the desired area*/


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (top == -1) {
                        top = i;
                    }
                    bottom = i;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    if (left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }
        }

        return (bottom - top + 1) * (right - left + 1);
    }

}
