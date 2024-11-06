package codeforces.recursion;

import java.io.*;
import java.util.*;
public class TransformAToB{
    public static void main(String asd[]) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        long input[]=Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n=input[0];
        long m=input[1];
        List<Long> sequence=new ArrayList<>();
        //sequence.add(m);//if using isTransformed2
        sequence.add(n); //if using isTransformed
        if(isTransformed(n,m,sequence)){
          System.out.println("YES");
          System.out.println(sequence.size());
          /*if using isTransformed2
          for(int i=sequence.size()-1;i>=0;i--) {
              System.out.print(sequence.get(i)+" ");
          }*/
          //if using isTransformed
          for(int i=0;i<sequence.size();i++) {
                System.out.print(sequence.get(i)+" ");
            }
        }else{
            System.out.println("NO");
        }
    }

    static boolean isTransformed(long n,long m,List<Long> sequence){
        System.out.println(sequence);
        if(n==m){
            return true;
        }
        if(n>m){
            return false;
        }
        //Action
        n=n*2;

        sequence.add(n);
        //Recurse
        boolean multipliedByTwo=isTransformed(n,m,sequence);
        //BackTrack
        if(!multipliedByTwo) {
            sequence.remove(sequence.size()-1);
        }
            n/=2;
           //Action
            n=(n*10)+1;
            sequence.add(n);
            System.out.println(n);
        //Recurse
        boolean tenXPlusOne=isTransformed(n,m,sequence);
        //Backtrack
        if(!tenXPlusOne) {
            System.out.println(sequence.get(sequence.size()-1));
            sequence.remove(sequence.size()-1);
        }
        return multipliedByTwo||tenXPlusOne;
    }
    static boolean isTransformed2(long n ,long m, List<Long>sequence){
        boolean flag=false;
        System.out.println(sequence);
        if(n==m){
            return true;
        }
        if(n>m){
            sequence.remove(sequence.size()-1);
            return false;
        }
        if(m%2==0){
            sequence.add(m/2);
            flag= isTransformed2(n,m/2,sequence);
        }
        else if(m%10==1){
            sequence.add(m/10);
            flag= isTransformed2(n,m/10,sequence);
        }
        return flag;
    }
}