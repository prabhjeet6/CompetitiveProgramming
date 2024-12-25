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


    public static void main(String[] a) {

        //["MyCircularQueue","Rear","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue"]
        //[[3],[],[2],[3],[4],[],[],[],[4]]

        DesignCircularQueue q = new DesignCircularQueue(3);
        System.out.print(q.Rear() + " ");
        System.out.print(q.enQueue(2) + " ");
        System.out.print(q.enQueue(3) + " ");
        System.out.print(q.enQueue(4) + " ");
        System.out.print(q.Rear() + " ");
        System.out.print(q.isFull() + " ");
        System.out.print(q.deQueue() + " ");
        System.out.print(q.enQueue(0) + " ");

    }

    public boolean enQueue(int value) {
        if (counter >= queue.length) {
            return false;
        } else {
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
            return false;
        } else {
            counter--;
            queue[front] = -1;
            if (front < queue.length - 1) {
                front++;
            } else {
                front = 0;
            }
            return true;
        }
    }

    public int Front() {
        if (front < 0) return -1;
        return queue[front];
    }

    public int Rear() {
        if (rear < 0) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == queue.length - 1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */