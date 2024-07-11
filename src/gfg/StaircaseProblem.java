package gfg;


import java.util.Arrays;

class StaircaseProblem{

    public static void main(String as[]){
       System.out.println( countWays(4));
    }


    static int countWays(int n){
        int[] ans =new int[n+1];
        Arrays.fill(ans,-1);
        int mod= 1000000007;
        return totalWays(n, ans,mod);
        //return bottomTopDP(4);
    }

    //Bottom-Top DP
    static int bottomTopDP(int n){
        int mod= 1000000007;
        int f=1,s=2;
        if(n==1){
            return f;
        }
        for(int i=3;i<=n;i++){
            int temp=(f%mod+s%mod)%mod;
            f=s;
            s=temp;
        }
        return s%mod;
    }


    //Top-Bottom DP
    static private int totalWays(int n, int[] ans,int mod) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(ans[n]!=-1){
            return (int)ans[n]%mod;
        }
        ans[n]=(int)((totalWays(n-1,ans, mod)%mod +totalWays(n-2,ans, mod)%mod)%mod) ;

        return (int)ans[n]%mod;
    }

}