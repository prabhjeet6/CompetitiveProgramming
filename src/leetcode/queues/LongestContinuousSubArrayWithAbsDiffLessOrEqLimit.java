package leetcode.queues;


import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubArrayWithAbsDiffLessOrEqLimit {
    public static void main(String[] as) {
        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));//4
        //System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));//2
        //System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));//3
    }

    public static int longestSubarrayBruteForce(int[] nums, int limit) {
        int count = 0, max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((j + 1) < n && Math.abs(nums[j] - nums[j + 1]) <= limit) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(count, max);
            count = 0;
        }
        return limit == 0 ? max + 1 : max;
    }

    //TLE at TestCase 58
    public static int longestSubarrayUsingTwoPointers(int[] nums, int limit) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, windowSize = 0, left = 0, right = 0, n = nums.length;
        boolean windowBreakFound = false;
        while (right < n) {
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);
            int diff = Math.abs(max - min);

            if (diff > limit) {
                windowSize = Math.max(windowSize, right - left);
                left++;
                right = left;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                windowBreakFound = true;
            } else {
                right++;
                windowBreakFound = false;
            }

        }
        if (!windowBreakFound && (right - left) > windowSize) {
            windowSize = right - left;
        }
        return windowSize;
    }

    /*While heaps are commonly used to track max and min values, their frequent insertion and removal
    operations are inefficient (O(logn) time).
    Deques, or double-ended queues, offer efficient O(1) time
    complexity for adding and removing elements from both ends and are more suitable for this problem.

    We use two deques for this problem.
    One deque maintains numbers in decreasing order, ensuring the largest number in the window is always
    at the front. If a new number exceeds those at the deque's end, we remove those elements since
    they can no longer be the maximum in the current window.

    Similarly, the other deque will maintain the numbers in increasing order, ensuring the smallest
    number in the window is always at the front. If a new number is smaller than those at the deque's
    end, it replaces them, ensuring accuracy for the current window's minimum.

    These deques hold all the potential minimum and maximum values for the current and future windows.
    When expanding the window to include a new element, we add it to both deques while preserving their
    order. If the absolute difference between the maximum and minimum values at the front of the deques
    exceeds the limit, we shrink the window by moving the left pointer. Removing elements from the front
    of either deque maintains the correct min and max values in constant time, enabling efficient checks
    to ensure the window stays within the limit.*/

    //https://www.youtube.com/watch?v=Z3ObyfRFBtc
    public static int longestSubarray(int[] nums, int limit) {
        int windowSize = 0, left = 0, n = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {

            // maintain maxDeque in descending order for max values for current window
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // maintain minDeque in ascending Order for min values for current window
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            //check if the current window exceeds limit
            while (null != maxDeque.peekFirst() && null != minDeque.peekFirst()
                    && (maxDeque.peekFirst() - minDeque.peekFirst()) > limit) {
                //Because we are going to move the window by moving left, if any of these deque have these
                // values, that is, if max or min of the current window is at nums[left], then we pop it
                // before increasing left index, because new window won't have that value

                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() != null && minDeque.peekFirst().equals(nums[left])) {
                    minDeque.pollFirst();
                }
                left++;
            }
            windowSize = Math.max(windowSize, right - left + 1);
        }
        return windowSize;
    }
}
