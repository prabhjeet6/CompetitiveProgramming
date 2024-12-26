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
        rear = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            for (int i = deque.length - 1; i > 0; i--) {
                deque[i] = deque[i - 1];
            }
            deque[0] = value;
            counter++;
            rear++;
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
            if (rear == 0) rear = deque.length - 1;
            else rear = (rear - 1) % deque.length;
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

