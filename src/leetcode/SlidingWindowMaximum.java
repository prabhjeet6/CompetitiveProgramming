package leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

class SlidingWindowMaximum {
    public static void main(String[] ans) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //3,3,5,5,6,7
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int count = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            if (count == nums.length - k + 1) {
                break;
            }
            ans[count++] = max;

        }
        return ans;
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dequeue = new ArrayDeque<>();
        //iterate for first window
        for (int i = 0; i < k; i++) {
            addAtLast(dequeue, i, nums);
        }
        int counter = 0;
        //every iteration is a new window
        for (int i = k; i < nums.length; i++) {
            //As we are maintaining monotonic dequeue value at front of dequeue will be maximum of the window
            ans[counter++] = nums[dequeue.getFirst()];
            //if front of deque will not be part next window,then remove it from dequeue
            if (dequeue.getFirst() == i - k) {
                dequeue.removeFirst();
            }
            addAtLast(dequeue, i, nums);
        }
        ans[counter] = nums[dequeue.getFirst()];
        return ans;
    }

    private static void addAtLast(Deque<Integer> dequeue, int i, int[] nums) {
        while (!dequeue.isEmpty() && nums[dequeue.getLast()] <= nums[i]) {
            //if dequeue has values and current array value is greater than last dequeue value
            // (maintain monotonic decreasing deque)
            dequeue.removeLast();
        }
        //if dequeue is empty or if deque' last value is  greater than current
        // array element
        dequeue.addLast(i);
    }
}
