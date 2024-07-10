package gfg;


import java.util.Arrays;


/*
2 1 0 0  | 1 0 0 0
3 0 0 1  | 1 0 0 1
0 1 0 1  | 0 0 0 1
0 0 0 1  | 0 0 0 1

Rat started with matrix[0][0] and can jump up to 2 steps right/down. First check matrix[0][1] as it is 1,
next check matrix[0][2] ,this won't lead to the solution.
Then check matrix[1][0], as this is 3 (non-zero),so we can make 3 jumps to reach matrix[1][3]. From matrix[1][3]
 we can move downwards taking 1 jump each time to reach destination at
matrix[3][3].


The rat can move in only two directions: first forward if possible or down. If multiple solutions exist,
the shortest earliest hop will be accepted. For the same hop distance at any point, forward will be preferred
over downward. In the maze matrix, 0 means the block is the dead end and non-zero number means the block can be
used in the path from source to destination. The non-zero value of mat[i][j] indicates number of maximum jumps rat
 can make from cell mat[i][j]. In this variation, Rat is allowed to jump multiple steps at a time instead of 1.
 Find a matrix which describes the position the rat to reach at the destination.


make a solution matrix of NxN size and initialize the whole matrix with 0 .
 call the recursive function from the source that is (0,0) .
Now if we reach cell (N-1,N-1) , change sol[N-1][N-1] to 1 and return true , this is the base case . That means we reached the destination .
for every cell we will check . if the cell is inside the bound of the board and we can further jump from that cell or not
Otherwise we first we consider a path , sol[x][y] = 1 and recursively call the function
we will run a loop from 1 to maze[x][y] ,  because we can jump at most maze[x][y] jump from cell (x,y)
If there is no path found then we again make sol[x][y] = 0 then check for the next path
Now we found first path .. we will print the path
 */




class RatMazeWithMultipleHops{
    // Check if a given coordinates (x, y) are safe within the matrix boundaries and the value at that position is non-zero.
    static boolean isSafe(int x, int y, int[][] matrix){
        int n = matrix.length;
        return (x >= 0 && x < n && y >=0 && y < n && matrix[x][y] != 0);
    }
    public static void main(String[] as) {
        int[][] matrix = {{2, 1, 0, 0}, {3, 0, 0, 1}, {0, 1, 0, 1},
                {0, 0, 0, 1}};
        System.out.println(Arrays.deepToString(ShortestDistance(matrix)));
    }

    // Recursive helper function to find the shortest distance from (0, 0) to (n-1, n-1) in the matrix.
    static boolean helper(int x, int y, int[][] matrix, int[][] sol){
        int n = matrix.length;

        // If we have reached the destination (n-1, n-1), mark it as a valid path.
        if(x == n-1 && y == n-1){
            sol[x][y] = 1;
            return true;
        }

        // If we are at a safe position, mark it as a valid path and explore all possible steps.
        if(isSafe(x, y, matrix)){
            sol[x][y] = 1;

            // Explore all possible steps from the current position.
            for(int step = 1; step <= matrix[x][y] && step < n; step++){
                // Try moving right and check if it leads to a valid path.
                if(helper(x, y+step, matrix, sol))
                    return true;

                // Try moving down and check if it leads to a valid path.
                if(helper(x+step, y, matrix, sol))
                    return true;
            }

            // If no valid path is found, mark the current position as invalid and backtrack.
            sol[x][y] = 0;
            return false;
        }

        // If we are at an unsafe position, return false.
        return false;
    }

    public static int[][] ShortestDistance(int[][] matrix)
    {
        int  n = matrix.length;
        int [][] sol = new int[n][n];
        // Call the helper function to find the shortest distance path from (0, 0) to (n-1, n-1).
        helper(0, 0, matrix, sol);

        // If no valid path is found, return a matrix with a single element indicating failure.
        if(sol[n-1][n-1] == 0){
            int [][] ans = new int[1][1];
            ans[0][0] = -1;
            return ans;
        }

        // Otherwise, return the solution matrix representing the shortest distance path.
        return sol;
    }
}

