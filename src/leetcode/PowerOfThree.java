package leetcode;


class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;//checks for negative numbers
        if (n == 1) return true;////checks if n is 1 or reducible to 1
        return (n % 3 == 0) && isPowerOfThree(n / 3);//n%3 checks if number is actually a factor of 3, then recurse
    }

}