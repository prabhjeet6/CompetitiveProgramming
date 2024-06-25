package codeforces;



import java.io.*;
import java.util.*;
public class AXAxis{
    public static void main(String asd[]) throws IOException,Exception{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bufferedReader.readLine());
        while(t>0){
            t--;
            String input[]=bufferedReader.readLine().split(" ");
            int x1=Integer.parseInt(input[0]);
            int x2=Integer.parseInt(input[1]);
            int x3=Integer.parseInt(input[2]);
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<=10;i++){
                if(Math.abs(i-x1)+Math.abs(i-x2)+Math.abs(i-x3)<ans){
                    ans=Math.abs(i-x1)+Math.abs(i-x2)+Math.abs(i-x3);
                }
            }
            System.out.println(ans);

        }
    }
}
