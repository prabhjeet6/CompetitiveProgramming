package leetcode;
/***https://leetcode.com/problems/powx-n/description/*/
public class FastExponentiation {
     double res;
    public static void main(String args[]){
        System.out.println(new FastExponentiation().myPow(34.00515d,-3));
    }
    /***public static double myPow(double x, int n) {
        if(n==0)
            return 1d;
        if(n<0)                   //If n is negative
            return myPow(1/x, -n);
        double p=myPow(x,n/2);
        if(n%2==0)
            return p*p;
       else{
          // if(n==-1)
           //    return 1/p*1/p*1/x;
           return p*p*x;
        }

    }**/
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
