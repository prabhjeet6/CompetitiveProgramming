package miscellaneous;

import java.lang.*;
import java.io.*;


public class KthSmallestInArrayBinarySearchOnAnswer {
    static long  sortedIndex(long x,long a[]){
        //monotonicFunction
        long smallRank=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=x){
                smallRank++;
            }
        }
        return smallRank;
    }
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());
        long a[] = new long[(int)N];
        String arrayInput[]=bufferedReader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(arrayInput[i]);
        }
        long k = Long.parseLong(bufferedReader.readLine());
        long l=Integer.MAX_VALUE,h=Integer.MIN_VALUE,m=0l;
        for(int i=0;i<N;i++){
            if(l>a[i]){
                //min
                l=a[i];
            }
            if(h<a[i]){
                //max
                h=a[i];
            }
        }
        while(l<=h){
            m=(l+h)/2;
            long smallRank=sortedIndex(m,a);
            if(smallRank<k){
                l=m+1;
            }else{
                long smallRankOnLeftOfM=sortedIndex(m-1,a);
                if(smallRankOnLeftOfM<k){
                    System.out.print(m);
                    return;
                }else{
                    h=m-1;
                }

            }
        }

    }
}

