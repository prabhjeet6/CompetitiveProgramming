package leetcode;

/***https://leetcode.com/contest/weekly-contest-401/problems/find-the-n-th-value-after-k-seconds/description/*/
import java.math.*;
class NthValueAfterKSeconds {
    long[] compute(long[]precomp,int n){
        for(int i=1;i<n;i++){
            precomp[i]=(precomp[i]+precomp[i-1])%1000000007;
        }
        return precomp;
    }
    public int valueAfterKSeconds(int n, int k) {
        long precomp[]=new long[n];
        for(int i=0;i<n;i++){
            precomp[i]=1;
        }
        for(int i=0;i<k;i++){
            compute(precomp,n);
        }
        long modulo=1000000007;
        BigInteger res =new BigInteger(String.valueOf(precomp[n-1]));
        //Long res=precomp[n-1]%modulo;
        BigInteger mod=new BigInteger("1000000007");
        res=res.mod(mod);
        return res.intValue() ;
    }

}