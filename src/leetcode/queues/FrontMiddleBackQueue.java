package leetcode.queues;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class FrontMiddleBackQueue {

    int middle;
    Deque<Integer> queue;

    public FrontMiddleBackQueue() {
        middle = 0;
        queue = new LinkedList<>();
    }

    public void pushFront(int val) {
        queue.addFirst(val);
    }

    public void pushMiddle(int val) {
        //if queue is Empty, pushMiddle should allow insertion
        if (queue.isEmpty()) {
            queue.add(val);
            return;
        }
        //keep check of middle index for both push and pop operations depending upon number of elements
        // in queue
        if (queue.size() % 2 == 0) {
            middle = (queue.size() / 2) - 1;
        } else middle = queue.size() / 2;

        Stack<Integer> auxilliaryStack = new Stack<>();
        int count = 0, queueSize = queue.size();
        while (count < queueSize) {
            if (count == middle) {
                queue.push(val);
                break;
            }
            auxilliaryStack.push(queue.pop());
            count++;
        }
        while (!auxilliaryStack.isEmpty()) {
            queue.addFirst(auxilliaryStack.pop());
        }
    }

    public void pushBack(int val) {
        queue.addLast(val);
    }

    public int popFront() {
        if (queue.isEmpty()) return -1;
        return queue.removeFirst();
    }

    public int popMiddle() {
        if (queue.isEmpty()) return -1;
        if (queue.size() % 2 == 0) {
            middle = (queue.size() / 2) - 1;
        } else middle = queue.size() / 2;
        Stack<Integer> auxilliaryStack = new Stack<>();
        int count = 0, poppedVal = 0;
        while (count < queue.size()) {
            if (count == middle) {
                poppedVal = queue.pop();
                break;
            }
            auxilliaryStack.push(queue.pop());
            count++;
        }
        while (!auxilliaryStack.isEmpty()) {
            queue.addFirst(auxilliaryStack.pop());
        }
        return poppedVal;
    }

    public int popBack() {
        if (queue.isEmpty()) return -1;
        return queue.removeLast();
    }
}

