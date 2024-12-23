package leetcode.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {

    List<List<String>> ans = new ArrayList<>();

    public static void main(String as[]) {
        System.out.println(new NQueens().solveNQueens(4));
    }


    public List<List<String>> solveNQueens(int n) {
        char[][] chessGrid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessGrid[i][j] = '.';
            }
        }
        solve(n, 0, chessGrid);
        return ans;
    }

    void solve(int n, int r, char[][] chessGrid) {

        if (n == r) {
            List<String> config = new ArrayList<>();
            String tempRow = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tempRow += chessGrid[i][j] ;
                }
                tempRow = tempRow.substring(0, tempRow.length() );
                config.add( tempRow );
                tempRow = "";
            }
            ans.add(config);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (isSafe(r, c, chessGrid, n)) {
                chessGrid[r][c] = 'Q';
                solve(n, r + 1, chessGrid);
                chessGrid[r][c] = '.';
            }
        }
    }


    boolean isSafe(int i, int j, char[][] chessGrid, int n) {
        int x = i - 1;
        while (x >= 0) {
            if (chessGrid[x][j] == 'Q') {
                return false;
            }
            x--;
        }
        x = i - 1;
        int y = j - 1;
        while (x >= 0 && y >= 0) {
            if (chessGrid[x][y] == 'Q') {
                return false;
            }
            x--;
            y--;
        }
        x = i - 1;
        y = j + 1;
        while (x >= 0 && y < n) {
            if (chessGrid[x][y] == 'Q') {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

}
