package leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main() {

    }
}
class MyQueue {

    Stack<Integer> queueSimulator=new Stack();
    Stack<Integer>  auxillaryStack=new Stack();
    int front=0;
    public MyQueue() {

    }

    public void push(int x) {
        if(queueSimulator.isEmpty()){
            front=x;
        }
        queueSimulator.push(x);

    }

    public int pop() {
       while(!queueSimulator.isEmpty()){
           int val=  queueSimulator.pop();
           auxillaryStack.push(val);
       }
       int elementPopped=auxillaryStack.pop();
       if(!auxillaryStack.isEmpty()) {
           front = auxillaryStack.peek();
       }
        while(!auxillaryStack.isEmpty()){

            int val=  auxillaryStack.pop();
            queueSimulator.push(val);
        }
        return  elementPopped;
    }

    public int peek() {
    return front;
    }

    public boolean empty() {
    return queueSimulator.isEmpty();
    }
}

