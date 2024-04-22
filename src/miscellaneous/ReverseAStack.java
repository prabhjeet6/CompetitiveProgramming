package miscellaneous;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseAStack {
    public static void main(String args[]) throws IOException {
        Scanner scanner=new Scanner(System.in);
        //scanner.useDelimiter("[\\s]*");
        int N=scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            int num=scanner.nextInt();
            stack.push(num);
        }
        reverseStack(stack);
        //pushBottomIterative(stack,6);
        //pushBottomRecursive(stack,6);
        print(stack);
        scanner.close();
    }
    public static void print(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int x=st.pop();
        print(st);
        System.out.print(x+ " ");
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        //stack.push(top);
        pushBottomRecursive(stack, top);
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
