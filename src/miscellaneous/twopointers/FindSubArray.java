package miscellaneous.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindSubArray {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            long NS[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long N = NS[0];
            long S = NS[1];
            long[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            findSubArrayIndices(arr, S);
        }
    }

    private static void findSubArrayIndices(long[] arr, long S) {
        int l = 0, r = 0;
        long sum = 0l;
        boolean flag = false;
        sum = arr[l];
        while (r < arr.length  && l< arr.length ) {
            if (sum == S) {
                System.out.println((l + 1) + " " + (1 + r));
                flag = true;
                return;
            } else if (sum < S) {
                r++;
                //edge case
                if (r < arr.length) {
                    sum += arr[r];
                }
            } else {
                sum -= arr[l];
                l++;
                //edge case
                if(l>r){
                    r++;
                    if(r<arr.length) {
                        sum +=arr[r];
                    }
                }
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }
}
