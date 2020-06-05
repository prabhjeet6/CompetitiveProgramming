import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  static  BigInteger factorial=new BigInteger("1");
    // Complete the extraLongFactorials function below.
    static BigInteger extraLongFactorials(int n) {
        // BigInteger number=new BigInteger(n);
     if(n>1)
     factorial=extraLongFactorials(n-1).multiply(BigInteger.valueOf(n));
     if(n==0)return factorial;
     return factorial;
      
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        extraLongFactorials(n);
        System.out.print(factorial);
        scanner.close();
    }
}
