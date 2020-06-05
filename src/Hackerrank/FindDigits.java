import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n){
        int copy=n;
        int i=0,divisor=0;
        int digit[]=new int[100000];
        while(copy>0){
            digit[i]=copy%10;
            i++;
            copy/=10;
        }
        for(int j=0;j<i;j++)
        {
            if(digit[j]!=0&&n%digit[j]==0)
            divisor++;

        }
        return divisor;
       // System.out.print(divisor);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
    
}
