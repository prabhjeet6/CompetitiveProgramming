package leetcode.searching;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
/* Name of the class has to be "Main" only if the class is public. */
public class FirstAndLastPosition {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = Integer.parseInt(bf.readLine());
        while (t > 0) {
            t--;
            int target = Integer.parseInt(bf.readLine());
            int start = findFirst(nums, target);
            if (start != -1) {
                int end = findLast(nums, target);
                System.out.print(start+" "+end);
            } else {
                System.out.print(-1);
            }
            System.out.println();
        }
    }

    static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                //target found and is first occurrence
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                //target found and is the last element
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
