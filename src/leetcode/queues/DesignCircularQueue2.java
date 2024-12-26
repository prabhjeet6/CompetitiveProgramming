package leetcode.queues;

class DesignCircularQueue2 {


    private int[] queue;
    private int counter;
    private int front;
    private int rear;


    public DesignCircularQueue2(int k) {
        queue = new int[k];
        counter = 0;
        front = 0;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % queue.length; // Move rear in a circular manner
        queue[rear] = value;
        counter++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % queue.length; // Move front in a circular manner
        counter--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == queue.length;
    }
}

