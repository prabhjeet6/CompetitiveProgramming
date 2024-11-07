package miscellaneous.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnsortedSubArray {
    public static void main(String[] as) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] copy = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy);
            solve(nums, copy);
        }

    }

    static void solve(int[] nums, int[] copy) {
        int u = 0, v = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                u = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (copy[i] != nums[i]) {
                v = i;
                break;
            }
        }
        System.out.println(u + " " + v);
    }
}
