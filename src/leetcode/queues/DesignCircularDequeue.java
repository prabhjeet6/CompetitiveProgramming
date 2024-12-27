package leetcode.queues;

class DesignCircularDequeue {
    int counter;
    int[] deque;
    int front;
    int rear;

    public DesignCircularDequeue(int k) {
        counter = 0;
        deque = new int[k];
        front = 0;
        rear = k - 1;//rear should start from last index of dequeue
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            //Adjust front to insert at front of the deque
            front = (front - 1 + deque.length) % deque.length;
            deque[front] = value;
            counter++;

            return true;
        }
    }


    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            rear = (rear + 1) % deque.length;
            counter++;
            deque[rear] = value;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % deque.length;
            counter--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            rear = (rear - 1 + deque.length) % deque.length;
            counter--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == deque.length;
    }
}

