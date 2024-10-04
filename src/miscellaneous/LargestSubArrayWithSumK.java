package miscellaneous;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class LargestSubArrayWithSumK {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T > 0) {
            T--;
            String[] input = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            long[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] prefixSum = new long[N];
            prefixSum[0] = arr[0];
            for (int i = 1; i < N; i++) {
                prefixSum[i] = arr[i] + prefixSum[i - 1];
            }
            Map<Long, Long> map = new HashMap<>();
            map.put(0L, -1L);
            boolean found = false;
            long maxSubArrayLength = -1L;
            for (int i = 0; i < N; i++) {
                if (map.containsKey(prefixSum[i] - k)) {
                    found = true;
                    maxSubArrayLength = Math.max(maxSubArrayLength, i - map.get(prefixSum[i] - k));
                } else {
                    //insert  (prefixSum[i], i) for each index so that other indices
                    // can check for it, and if it is present then access its index
                    map.put(prefixSum[i], (long) i);
                }
            }
            if (!found) {
                System.out.println(0);
            } else {
                System.out.println(maxSubArrayLength);
            }
        }
        bufferedReader.close();

    }
}