package gfg.twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class MinimizeTheExpression {
    //https://www.geeksforgeeks.org/minimize-maxai-bj-ck-minai-bj-ck-three-different-sorted-arrays/
    // Minimize the Expression: max(a,b,c)-min(a,b,c) where a,b,c belong from three sorted Arrays A,B,C
    public static void main(String asd[]) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long A[] = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long B[] = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long C[] = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        // Using Two pointers approach
        minimizeTheExpression(A, B, C);
    }

    private static void minimizeTheExpression(long[] a, long[] b, long[] c) {
        long ans = Long.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            long minElement = a[i] < (b[j] < c[k] ? b[j] : c[k]) ? a[i] : (b[j] < c[k] ? b[j] : c[k]);
            long exp = a[i] > (b[j] > c[k] ? b[j] : c[k]) ? a[i] : (b[j] > c[k] ? b[j] : c[k]) - minElement;
            ans = exp < ans ? exp : ans;
            if (a[i] == minElement) {
                i++;
            }
            else if (b[j] == minElement) {
                j++;
            }
            else {
                k++;
            }

        }
    }

}
