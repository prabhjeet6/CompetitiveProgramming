
package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MazeProblem {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastScanner s = new FastScanner();
        int t = s.nextInt();
        while (t > 0) {
            t--;
            int n = s.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = s.nextInt();
                }
            }
            boolean[][] isVisited = new boolean[n][n];
            List<String> res=new ArrayList<>();
            paths( matrix, n, 0, 0, isVisited,new ArrayList<>(),res);

            Collections.sort(res);
            for(String path: res){
                System.out.print(path+ " ");
            }
            System.out.println();
        }
        s.close();
    }

    static void paths( int[][] matrix, int n, int i, int j, boolean[][] isVisited, List<Character> temp, List<String> res ) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1 || isVisited[i][j] || matrix[i][j] == 0) {
            return;
        }
        if (i == j && i == n - 1) {
            StringBuffer sb=new StringBuffer();
            for(Character c:temp){
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        isVisited[i][j] = true;

        temp.add('R');
        paths( matrix, n, i, j + 1, isVisited,temp,res);
        temp.remove(temp.size()-1);

        temp.add('D');
        paths( matrix, n, i + 1, j, isVisited,temp,res);
        temp.remove(temp.size()-1);

        temp.add('U');
        paths( matrix, n, i - 1, j, isVisited,temp,res);
        temp.remove(temp.size()-1);

        temp.add('L');
        paths( matrix, n, i, j - 1, isVisited,temp,res);
        temp.remove(temp.size()-1);


        isVisited[i][j] = false;
    }
}