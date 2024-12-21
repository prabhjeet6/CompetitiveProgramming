package leetcode.stacks;

import java.util.Stack;

//https://leetcode.com/problems/132-pattern/description/
//A subsequence is derived from the input  by deleting zero or more elements
// from the input  without changing the order of the remaining elements.

//https://www.youtube.com/watch?v=yL8a7nnb8xw
class OneThirtyTwoPattern {
    public static void main(String[] as) {
        System.out.println(find132pattern(new int[]{1, 0, 1, -4, -3})); // false
        System.out.println(find132pattern(new int[]{3, 5, 0, 3, 4})); // true
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));// true 1 4  2
        System.out.println(find132pattern(new int[]{-1, 3, 2, 0}));// true [-1, 3, 2], [-1, 3, 0]  [-1, 2, 0].
    }

    //i < j < k and nums[i] < nums[k] < nums[j].
    //{3, 5, 0, 3, 4} -> 0,3,4
    //TC: O(N^3) SC:O(1)
    public static boolean find132patternBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] < nums[j] && nums[i] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //TC:O(N^2) SC:O(1)
    public static boolean find132patternApproach2(int[] nums) {
        int n = nums.length;
        //We take minElement indicating ith Element,
        // we track jth and kth Element using nested loops
        int minElement = nums[0];
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j] && minElement < nums[k]) {
                    return true;
                } else {
                    //In case, nums[k]>minElement we update the value of minElement to the closest
                    //possible index, that is, value at jth index
                    minElement = Math.min(minElement, nums[j]);
                }
            }
        }
        return false;
    }

    //TC:O(N) SC:O(1)
    public static boolean find132pattern(int[] nums) {
        int thirdElement = Integer.MIN_VALUE;//maintains kth Element
        Stack<Integer> stack = new Stack<>();//Monotonic stack, maintains 32 pattern
        // we are looping in reverse order because while the  loop is maintaining ith Element but, jth and kth Element will be found
        // after ith Element. stack maintains '32' part of '132' pattern, and stores jth Element
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < thirdElement) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                thirdElement = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
