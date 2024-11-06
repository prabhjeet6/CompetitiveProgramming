package miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AssesmentProblem {
    //19=1+9+9 3 steps
    //20=1+9+9 +1 3 steps
    public static void main(String[] a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bufferedReader.readLine());
        long steps = 1,count=1;
        while (n - 1 > steps) {
            if (steps + 9 <= n) {
                steps += 9;
                count++;
            }
        }
        System.out.println(count);
    }

}
