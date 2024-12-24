package leetcode.design;

import java.util.Stack;

class Pair{
    int val;
    int minVal;
}
class MinStack {

    Stack<Pair> stack;
    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int val) {
        Pair p=new Pair();
        if(stack.isEmpty()){
            p.val=val;
            p.minVal=val;
        }else{
            int currentMin=stack.peek().minVal;
            p.val=val;
            if(currentMin>val){
                p.minVal=val;
            }else{
                p.minVal=currentMin;
            }
        }
        stack.push(p);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */