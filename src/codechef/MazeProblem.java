
package codechef;

import java.util.Arrays;
import java.util.Scanner;

class MazeProblem {
    static String ans = "";

    public static void main(String[] args) throws java.lang.Exception {

        Scanner s = new Scanner(System.in);
        try {
            int t = 0;
            if (s.hasNext())
                t = s.nextInt();

            while (t > 0) {
                t--;
                int n = 0;
                if (s.hasNext())
                    n = s.nextInt();

                int matrix[][] = new int[n][n];
                String input[] = new String[n * n];
                String in = "";
                s.useDelimiter("\\n");
                if (s.hasNext()) {
                    in = s.next();
                }
                input = in.split(" ");
                int counter = 0;
                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(input[counter]);
                        counter++;
                    }
                }
                counter = 0;
                boolean isVisited[][] = new boolean[n][n];
                paths("", matrix, n, 0, 0, isVisited);
                String[] tokens=ans.trim().split(" ");
                Arrays.sort(tokens);
                for(String token:tokens){
                    System.out.print(token+" ");
                }
                //System.out.println(ans.trim());
                ans = "";

            }
        } catch (Exception e) {

        }
        s.close();

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

        isVisited[i][j] = true;

        paths(res + "R", matrix, n, i, j + 1, isVisited);
        paths(res + "D", matrix, n, i + 1, j, isVisited);
        paths(res + "U", matrix, n, i - 1, j, isVisited);
        paths(res + "L", matrix, n, i, j - 1, isVisited);

        res = !res.isEmpty() ? res.substring(0, res.length() - 1) : res;

        isVisited[i][j] = false;


    }

}