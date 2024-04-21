package miscellaneous;

import java.util.Iterator;
import java.util.Stack;

public class ReverseAstack {
    public static void main(String args[]){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //pushBottomIterative(stack,4);
        //pushBottomRecursive(stack,4);
        reverseStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int top=stack.pop();
        reverseStack(stack);
        pushBottomRecursive(stack,top);
    }

    private static void pushBottomRecursive(Stack<Integer> stack,int x) {
    if(stack.isEmpty()){
       stack.push(x);
        return;
    }
    int top=stack.pop();
    pushBottomRecursive(stack,x);
    stack.push(top);
    }

    private static void pushBottomIterative(Stack<Integer> stack,int x) {
        Stack<Integer> tempStack=new Stack<>();
        while(!stack.isEmpty()){
            int top=stack.pop();
            tempStack.push(top);
        }
        stack.push(x);
        while(!tempStack.isEmpty()){
            int top=tempStack.pop();
            stack.push(top);
        }

    }
    
}
