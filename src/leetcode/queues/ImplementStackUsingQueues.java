package leetcode.queues;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementStackUsingQueues {
    public static void main(String[] args){
       ImplementStackUsingQueues stack= new ImplementStackUsingQueues();
       stack.push(1);
       stack.push(2);
       stack.push(3);
       stack.push(4);
       stack.push(2);
       System.out.println(stack.top());
       System.out.println(stack.pop());
       System.out.println(stack.top());


    }

   Integer top=null;
    Queue<Integer> stackSimulator=new ConcurrentLinkedQueue<>();
    Queue<Integer> auxilliaryQueue=new ConcurrentLinkedQueue<>();


    public ImplementStackUsingQueues() {

    }

    public void push(int x) {
     top=x;
     stackSimulator.add(x);
    }

    public Integer pop() {
        Integer elementToBePopped=null;
        while (!stackSimulator.isEmpty()&&stackSimulator.size()!=1){
              auxilliaryQueue.add(stackSimulator.poll());
        }
        if(!stackSimulator.isEmpty()) {
             elementToBePopped = stackSimulator.poll();
        }
        while (!auxilliaryQueue.isEmpty()){
            if(auxilliaryQueue.size()==1){
                top=auxilliaryQueue.peek();
            }
            stackSimulator.add(auxilliaryQueue.poll());
        }
    return elementToBePopped;
    }

    public Integer top() {
     return top;
    }

    public boolean empty() {
      return stackSimulator.isEmpty();
    }
}

