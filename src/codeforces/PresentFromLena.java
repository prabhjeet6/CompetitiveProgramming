package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://codeforces.com/problemset/problem/118/B
//https://www.youtube.com/watch?v=Zvk8v3x_Nvg
public class PresentFromLena {
    public static void main(String[] a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for(int row=-n;row<=n;row++){
            int spaces=2*Math.abs(row);
            for(int i=0;i<spaces;i++){
                System.out.print(" ");
            }
            int max=n-Math.abs(row);
            for(int i=0;i<max;i++){
                System.out.print(i+" ");
            }
            for(int i=max;i>0;i--){
                System.out.print(i+" ");
            }
            System.out.println(0);
        }
    }


}

