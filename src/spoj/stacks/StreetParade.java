package spoj.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//https://www.spoj.com/problems/STPAR/
public class StreetParade {
    public static void main(String[] a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] nums;
        while (true) {
            n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) break;
            nums = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            getIsPossible(nums);
        }
    }

    //5 1 2 4 3


    //10
    //1 2 10 5 4 3 9 8 7 6
    //yes
    static void getIsPossible(int[] nums) {
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (num != count) {
                stack.push(num);
            } else {
                count++;
                if (!stack.isEmpty() && stack.peek() == count) {
                    while (!stack.isEmpty() && stack.peek() == count) {
                        stack.pop();
                        count++;
                    }
                }
            }
        }
        while (!stack.isEmpty() && count == stack.peek()) {
            stack.pop();
            count++;
        }
        if (stack.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}
