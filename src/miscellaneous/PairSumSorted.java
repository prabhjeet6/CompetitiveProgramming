package miscellaneous;


import java.util.*;
import java.lang.*;
import java.io.*;

public class PairSumSorted {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(bf.readLine());
        int i = 0, index = 0;
        for (i = 0; i < n; i++) {
            index = binarySearch(nums, target - nums[i]);
            if(index==i){
                /* Edge case:
                Ex: [1,2,5,6,9]. Target - 12
                 Now if you select 6 and apply binary search to find (Target-6) = 6.
                 Then you can find the same 6 again. But this should not happen.*/
                continue;
            }
            if (index != -1) {

                break;
            }
        }
        if (i > index) {
            System.out.print((index + 1) + " " + (i + 1));
        } else {
            System.out.print((i + 1) + " " + (index + 1));
        }

    }

    static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

