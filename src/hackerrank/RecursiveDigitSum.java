package hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//Gives TLE for some testcases due to Large Input
/*class Result {




    public static int superDigit(String n, int k) {
        String nCopy=n;
        for(int i=0;i<k-1;i++){
            n+=nCopy;
        }
        return recurse(new BigInteger(n),0);
    }
    static int recurse(BigInteger res,int ans){
        if(ans<10&&res.equals(BigInteger.ZERO)){
            return ans;
        }
        if(res.equals(BigInteger.ZERO)){
            res=new BigInteger(String.valueOf(ans));
            ans=0;
        }
        ans+=res.mod(BigInteger.TEN).intValue();

        return recurse(res.divide(BigInteger.TEN),ans);

    }

}*/
//Does not give TLE due to Large Input
class Result {
    public static int superDigit(String n, int k) {
        long a=digitsum(n);
        long t= (a*k);
        return Super(t);
    }
    public static long digitsum(String n){
        long sum=0;
        for(char c : n.toCharArray()){
            sum=sum+Character.getNumericValue(c);
        }
        return sum;
    }
    public static int Super(long t){
        if(t<10){
            return (int)t;
        }
        return Super((t%10)+Super(t/10));
    }
}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
