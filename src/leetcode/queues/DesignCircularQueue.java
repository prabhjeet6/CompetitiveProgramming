package leetcode.queues;


import java.util.Arrays;

class DesignCircularQueue {

    int[] queue;
    int counter;
    int front = -1;
    int rear = -1;

    public DesignCircularQueue(int k) {
        queue = new int[k];
        counter = 0;
        Arrays.fill(queue, -1);
    }

    public boolean enQueue(int value) {
        if (counter >= queue.length) {
            // setting rear and front values here should not be done, as a call to Rear() will throw ArrayIndexOutOfBounds
            return false;
        } else {
            //Enqueue and Dequeue work in similar circular logic
            counter++;
            if (front == -1 && rear == -1) {
                front = 0;
                rear = 0;
            } else {
                if (rear < queue.length - 1) {
                    rear++;
                } else {
                    rear = 0;
                }
            }
            queue[rear] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if (counter == 0) {
            // setting rear and front values here should not be done, as a call to Front() will throw ArrayIndexOutOfBounds
            return false;
        } else {
            //Enqueue and Dequeue work in similar circular logic
            counter--;
            queue[front] = -1;//Important, reset value at dequeued index to -1
            if (front < queue.length - 1) {
                front++;
            } else {
                front = 0;
            }
            return true;
        }
    }

    public int Front() {
        // If front index is invalid, return -1
        if (front < 0) return -1;
        return queue[front];
    }

    public int Rear() {
        // If front index is invalid, return -1
        if (rear < 0) return -1;
        return queue[rear];
    }

    // Only depend upon counter to check for isEmpty() or isFull()
    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == queue.length - 1;
    }
}
