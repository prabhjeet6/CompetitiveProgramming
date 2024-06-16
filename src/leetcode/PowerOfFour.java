package leetcode;


class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if(n<=0)return false;//checks if number is negative
        if(n==1)return true;//checks if n is 1 or reducible to 1
        return n%4==0 && isPowerOfFour(n/4);//n%4 checks if number is actually a factor of 4, then recurse
    }
}