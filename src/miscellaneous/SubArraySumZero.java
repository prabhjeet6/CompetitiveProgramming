package miscellaneous;


import java.util.*;
import java.lang.*;
import java.io.*;

public class SubArraySumZero {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T > 0) {
            T--;
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] prefixSum = new int[N];
            prefixSum[0] = arr[0];
            for (int i = 1; i < N; i++) {
                prefixSum[i] = arr[i] + prefixSum[i - 1];
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            boolean found = false;
            for (int i = 0; i < N; i++) {
                if (map.containsKey(prefixSum[i])) {
                    System.out.println("Yes");
                    found = true;
                    break;
                } else {
                    map.put(prefixSum[i], 1);
                }
            }
            if (!found) {
                System.out.println("No");
            }
        }
        bufferedReader.close();

    }
}