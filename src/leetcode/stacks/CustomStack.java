package leetcode.stacks;

import java.util.Stack;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/
class CustomStack {

    int maxSize;
    Stack<Integer> stack;
    int count;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Stack<>();
        count = 0;
    }

    public void push(int x) {
        if (count < maxSize) {
            stack.push(x);
            count++;
        }
    }

    public int pop() {
        if (stack.isEmpty() ) {
            count = 0;
            return -1;
        } else {
            count--;
            return stack.pop();
        }
    }

    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();
        int count = 0;
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()) {
            if (count < k) {
                stack.push(temp.pop() + val);
                count++;
            } else {
                stack.push(temp.pop());
            }
        }

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */