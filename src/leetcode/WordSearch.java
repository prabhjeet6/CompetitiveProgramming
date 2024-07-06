package leetcode;
//Time Complexity: O(m∗n∗4^l ), where m and n are the dimensions of the grid and l is the length of the word. The 4^l
//  factor represents the maximum number of recursive calls we may have to make for each starting cell.
//Space complexity:
//O(l), where l is the length of the word. The space complexity is primarily due to the recursive stack depth during the DFS traversal.

class WordSearch {
    public static void main(String[] a) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch().exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(isExist(board, word, i, j, 0, m, n,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean isExist(char[][] board, String word, int i, int j, int currentCharIndex, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || board[i][j] != word.charAt(currentCharIndex)) {
            return false;
        }
        if (currentCharIndex == word.length() - 1 && board[i][j] == word.charAt(currentCharIndex)) {
            return true;
        }

        visited[i][j]=true;

        if (isExist(board, word, i, j + 1, currentCharIndex + 1, m, n,visited) ||
                isExist(board, word, i + 1, j, currentCharIndex + 1, m, n,visited) ||
                isExist(board, word, i - 1, j, currentCharIndex + 1, m, n,visited) ||
                isExist(board, word, i, j - 1, currentCharIndex + 1, m, n,visited)) {
            return true;
        }
        visited[i][j]=false;
    return false;
    }
}