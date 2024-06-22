package codeforces;


import java.io.*;
import java.util.*;

/***https://codeforces.com/contest/676/problem/B**/
public class PyramidOfGlasses {
    public static void main(String arg[]) throws IOException, Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input[] = bufferedReader.readLine().split(" ");
        //height of  pyramid
        int n = Integer.parseInt(input[0]);
        //time or total champagne
        int t = Integer.parseInt(input[1]);
        double glasses[][]=new double[15][15];
        int count=0;
        //for simplicity, index is starting from 1
        glasses[1][1]=t;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                //ith level is overflowing
                if(glasses[i][j]>=1d) {
                    count++;
                    //overflow is split between i+1th row's jth and j+1th glass
                    glasses[i + 1][j]  = glasses[i + 1][j]+(glasses[i ][j] - 1d) / 2d;
                    glasses[i + 1][j+1]  =glasses[i + 1][j+1] + (glasses[i ][j] - 1d) / 2d;
                }
            }
        }
        System.out.print(count);
    }
}