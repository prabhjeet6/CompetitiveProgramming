package leetcode;
/***https://leetcode.com/problems/powx-n/description/*/
public class FastExponentiation {
     double res;
    public static void main(String args[]){
        System.out.println(new FastExponentiation().myPow(34.00515d,-3));
    }
    //iterative Fast Exponentiation
    static long power(long x, long y) {
        //iterative Fast Exponentiation
        long res = 1;
        //bitwise & identifies if the right most bit is 1, suggesting number is odd
        while (y > 0) {
            //after multiplying the number once, power decreases by 1 and  becomes even(line 16 and 17)
            if ((y & 1) == 1) res = (res * x) ;
            y = y >> 1;
            x = (x * x);
        }
        return res;
    }
//ref: https://leetcode.com/problems/powx-n/solutions/1841398/java-100-recursive-solution-divide-conquer/
    public   double myPow(double x, int n) {
        return pow(x,n);
    }
    /*Here long n is necessary for handling boundary n conditions e.g. Integer.MAX_VALUE or Integer.MIN_VALUE*/
    public  double pow(double x, long n){
        if(n==0)
            return 1;
        if(n<0)                   //If n is negative
            return pow(1/x, -n);
        res=pow(x*x,n/2);
        if(n%2==1)               //If n is odd
            res=res*x;
        return res;
    }

}
