package leetcode;
//https://leetcode.com/problems/unique-paths-iii/

//there may exist a path that reaches from start to end, and all the nodes in the path were visited only once, but,
// the requirement here is to cover all the safe nodes once, hence, even if all  the path nodes were visited only
// once, but, even one node left uncovered will make the path incorrect.

class UniquePaths3 {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0, a = 0, b = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) zero++;
                else if (grid[r][c] == 1) {
                    a = r;
                    b = c;
                }
            }
        }
        return path(grid, a, b, zero);
    }

    private int path(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return 0;
        if (grid[x][y] == 2) {
            //We are checking for zero==-1 because in the first pass of path(...), we are decrementing 'zero' for
            //the node that is marked as 1 (start node), instead of 0
            return zero == -1 ? 1 : 0;
        }
        //Action
        grid[x][y] = -1;
        zero--;
        //DFS, as a node  visits all its neighbours
        //The time complexity will be O(3 ^ n), where n is the total number of cells without obstacles,
        // because for all cells except the first one, we'll have 3 choices for the next cell,
        // since we cannot visit the previous cell in the path again.
        //There are 4 directions we can go, but we can only try at most 3 of them at any moment.
        //TC: O(4*3^n)=O(3^n)
        int totalCount = path(grid, x + 1, y, zero) + path(grid, x, y + 1, zero) +
                path(grid, x - 1, y, zero) + path(grid, x, y - 1, zero);
        //Backtrack
        grid[x][y] = 0;
        zero++;

        return totalCount;
    }
}