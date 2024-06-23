package codeforces;


import java.io.*;
import java.util.*;

/***https://codeforces.com/contest/676/problem/B**/

//Refer for concept
/***https://www.youtube.com/watch?v=HIpl3XzxJQ4&t=768s*/
public class PyramidOfGlasses {
    public static void main(String arg[]) throws IOException, Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input[] = bufferedReader.readLine().split(" ");
        //height of  pyramid
        int n = Integer.parseInt(input[0]);
        //time or total champagne
        int t = Integer.parseInt(input[1]);
        double glasses[][] = new double[15][15];
        int count = 0;
        //for simplicity, index is starting from 1
        glasses[1][1] = t;
       // pyramidOfGlassesIterative(n, glasses, count);

        countglass(3,5,1,1,0,glasses);
    }

    static void pyramidOfGlassesIterative(int n, double glasses[][], int count) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //jth glass in ith row  is overflowing
                if (glasses[i][j] >= 1d) {
                    count++;
                    //overflow is split between i+1th row's jth and j+1th glass
                    glasses[i + 1][j] = glasses[i + 1][j] + (glasses[i][j] - 1d) / 2d;
                    glasses[i + 1][j + 1] = glasses[i + 1][j + 1] + (glasses[i][j] - 1d) / 2d;
                }
            }
        }
        System.out.print(count);
    }

    //Recursive
    static void countglass(int n, double t, int i, int j, int ans, double g[][]) {
        if (i == n + 1) {
            System.out.print(ans);
            return;
        }
        if (g[i][j] >= 1d) {
            ans++;
            g[i + 1][j] += (g[i][j] - 1d) / 2d;
            g[i + 1][j + 1] += (g[i][j] - 1d) / 2d;
        }
        if (j == i) {
            countglass(n, t, i + 1, 1, ans, g);
        } else {
            countglass(n, t, i, j + 1, ans, g);
        }
    }
}