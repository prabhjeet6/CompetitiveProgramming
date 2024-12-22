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
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(1);
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
                ans.set(i, ans.get(i) + 1);
            }
            stack.push(arr[i]);
        }
        int diff = 0;
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i - 1) != 1)
                diff = (ans.get(i - 1) - 1);
            if (ans.get(i) != 1) {
                ans.set(i, ans.get(i) + diff);
            }
        }
        return ans;
    }
}
