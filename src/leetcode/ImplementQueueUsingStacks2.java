package leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks2 {

    ImplementQueueUsingStacks2() {

    }

    Stack<Integer> pushStack = new Stack();
    Stack<Integer> popStack = new Stack();
    int front = 0;
    int bottomOfPushStack;


    public void push(int x) {
        if (pushStack.isEmpty() && popStack.isEmpty()) {

            front = x;
        } else if (pushStack.isEmpty()) {
            bottomOfPushStack = x;
        }
        pushStack.push(x);

    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                int x = pushStack.pop();
                popStack.push(x);
            }
        }
        int x = popStack.pop();
        if (!popStack.isEmpty()) {
            front = popStack.peek();
        } else if (!pushStack.isEmpty()) {
            front = bottomOfPushStack;
        }
        return x;
    }
}

