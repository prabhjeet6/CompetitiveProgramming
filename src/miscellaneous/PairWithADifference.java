package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairWithADifference {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = bufferedReader.readLine().split(" ");
        long N = Long.parseLong(NK[0]);
        long K = Long.parseLong(NK[1]);
        long arr[] = Arrays.stream(bufferedReader.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
        //Using Two Pointers Technique
        pairWithADifference(arr,K);
    }
    //6 78
    //2 3 5 5 20 80

    // 3 2
    //1  4 6
    private static void pairWithADifference(long[] arr, long diff) {
        int l = 0, r =  1;
        boolean found = false;
        Arrays.sort(arr);
        while (r<arr.length) {
            if (arr[r] - arr[l] > diff) {
                //diff is smaller, decrease (arr[r] - arr[l])
                l++;
                if(l==r){
                    //diff is larger, increase (arr[r] - arr[l])
                    r++;
                }
            } else if (arr[r] - arr[l] < diff) {
               //diff is larger, increase (arr[r] - arr[l])
                r++;
            } else if (arr[r] - arr[l] == diff) {
                System.out.println("Yes");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No");
        }
    }

}
