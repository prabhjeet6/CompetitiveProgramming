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

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */


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
