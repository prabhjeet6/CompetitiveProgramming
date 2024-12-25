package gfg.queues;

//https://www.geeksforgeeks.org/problems/implement-queue-using-array/1
class ImplementQueueUsingArray {

    int front, rear;
    int[] arr = new int[100005];

    ImplementQueueUsingArray() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        arr[rear++] = x;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        if (front == rear) {
            return -1;
        } else {
            front++;
            return arr[front];
        }
    }
}
