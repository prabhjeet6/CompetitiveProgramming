package leetcode;
/***https://leetcode.com/problems/count-number-of-homogenous-substrings/description/*/
class Solution {
    public int countHomogenous(String s) {
        long count=1l;
        long sum=0l;
        long mod=1000000007l;
        char c=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=c){
                c=s.charAt(i);
                sum=sum+(count*(count+1))/2;
               // sum=sum+(count%mod*(count+1)%mod)%mod/2;
                count=1;
            }else{
                count++;
            }
        } 
        //number of substrings  
       sum=sum+(count*(count+1))/2;
       return (int)(sum%mod);  
    }
}