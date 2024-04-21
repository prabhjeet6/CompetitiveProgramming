package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseAStack {
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String input[] = bufferedReader.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        reverseStack(stack);
        //pushBottomIterative(stack,6);
        //pushBottomRecursive(stack,6);
        while (!stack.isEmpty()) {
            System.out.print(stack.peek()+" ");
            stack.pop();
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        stack.push(top);
        //pushBottomRecursive(stack, top);
    }

    private static void pushBottomRecursive(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int top = stack.pop();
        pushBottomRecursive(stack, x);
        stack.push(top);
    }

    private static void pushBottomIterative(Stack<Integer> stack, int x) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            tempStack.push(top);
        }
        stack.push(x);
        while (!tempStack.isEmpty()) {
            int top = tempStack.pop();
            stack.push(top);
        }
    }
}
