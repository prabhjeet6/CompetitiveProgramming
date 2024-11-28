package miscellaneous;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] as){
        //Min Heap
        Queue<Integer> queue=new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //After two iterations Queue size is 1 and 'i' is also 2
        for(int i=0;i<queue.size();i++){
            System.out.println(queue.peek());
            queue.poll();
        }
        System.out.println("hello : "+queue.peek());

        System.out.println();

        //Max Heap
        Queue<Integer> priorityQueue=new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        System.out.println(priorityQueue.size());

        for(int i=0;i<priorityQueue.size();i++){
            System.out.println(priorityQueue.peek());
            priorityQueue.poll();
        }
        System.out.println(priorityQueue.peek());

    }
}
