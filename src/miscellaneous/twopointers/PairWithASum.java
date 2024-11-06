package miscellaneous.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairWithASum {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = bufferedReader.readLine().split(" ");
        long N = Long.parseLong(NK[0]);
        long K = Long.parseLong(NK[1]);
        long arr[] = Arrays.stream(bufferedReader.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
        //Using Two Pointers Technique
        pairWithASum(arr,K);
    }

    private static void pairWithASum(long[] arr, long sum) {
        int l = 0, r = arr.length - 1;
        boolean found = false;
        Arrays.sort(arr);
        while (l < r) {
            if (arr[l] + arr[r] > sum) {
                //array is sorted, reducing (arr[l]+arr[r])'s value to match sum
                r--;
            } else if (arr[l] + arr[r] < sum) {
                //array is sorted, increasing (arr[l]+arr[r])'s value to match sum
                l++;
            } else if (arr[l] + arr[r] == sum) {
                System.out.println("YES");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("NO");
        }
    }


}
