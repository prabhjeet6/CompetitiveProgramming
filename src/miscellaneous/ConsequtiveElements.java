package miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ConsequtiveElements {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int arr[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            consequtiveElements(arr);
        }
    }
    private static void consequtiveElements(int[] arr) {
        /** We know that for any element satisfying such a condition - max - min = N-1 and the array will
         * contain all the elements from min to min+N-1.
         * Therefore, we can find min and max to check the first condition and use hashtables
         * to check if all the elements from min to min+N-1 lie in the array or not.
         Time complexity: O(N) */
        int min = Integer.MAX_VALUE;
        boolean flag=true;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            set.add(arr[i]);
        }
        for (int i = min; i <= min+arr.length-1; i++) {
            if(!set.contains(i)) {
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
