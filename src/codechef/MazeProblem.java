package codechef;


import java.util.*;
import java.lang.*;
import java.io.*;

class MazeProblem {
    static String ans = "";

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());

        while (t > 0) {
            t--;

            int n = Integer.parseInt(bufferedReader.readLine());

            int matrix[][] = new int[n][n];
            String input[] = bufferedReader.readLine().split(" ");
            int counter = 0;
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[counter]);
                    counter++;
                }
            }
            counter=0;
            boolean isVisited[][] = new boolean[n][n];
            paths("", matrix, n, 0, 0, isVisited);
            System.out.println(ans.trim());
            ans = "";


        }
    }

    static void paths(String res, int[][] matrix, int n, int i, int j, boolean isVisited[][]) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1 || isVisited[i][j]) {
            return;
        }
        if (matrix[i][j] == 0) {
            return;
        }

        if (i == j && i == n - 1) {
            ans += " " + res;

            return;
        }

        isVisited[i][j]=true;

        paths(res + "R", matrix, n, i, j + 1, isVisited);
        paths(res + "D", matrix, n, i + 1, j, isVisited);
        paths(res + "U", matrix, n, i - 1, j, isVisited);
        paths(res + "L", matrix, n, i, j - 1, isVisited);

        res = !res.isEmpty() ? res.substring(0, res.length() - 1):res;

        isVisited[i][j]=false;



    }

}