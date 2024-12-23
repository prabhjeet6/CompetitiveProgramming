package gfg.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] a) {
        System.out.println(calculateSpan(new int[]{100, 80, 60, 70, 60, 75, 85}));
        //[1, 1, 1, 2, 1, 4, 6]
        System.out.println(calculateSpan(new int[]{10, 4, 5, 90, 120, 80}));
        //[1, 1, 2, 4, 5, 1]
        System.out.println(calculateSpan(new int[]{11, 4, 5, 90, 120, 80}));
        //[1, 1, 2, 4, 5, 1]
    }

    public static ArrayList<Integer> calculateSpanBruteForce(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = i, count = 0;
            while (j >= 0 && arr[j] <= arr[i]) {
                count++;
                j--;
            }
            ans.add(count);
        }
        return ans;
    }

    //The stack should store indices of the elements rather than the elements themselves. The span
    // is not simply the count of popped elements or adding a difference. It should be the difference
    // between the current index i and the last index where a higher price was found (from the stack).
    //System.out.println(calculateSpan(new int[]{10, 4, 5, 90, 120, 80}));
    //[1, 1, 2, 4, 5, 1]
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans.add(i - stack.peek());
            } else {
                ans.add(1 + i);
            }
            stack.push(i);
        }

        return ans;
    }
}
