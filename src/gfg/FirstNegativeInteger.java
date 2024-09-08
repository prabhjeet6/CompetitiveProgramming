package gfg;

import java.util.*;
import java.lang.*;


class FirstNegativeInteger {

    public static void main(String[] as) {

        System.out.println(Arrays.toString(printFirstNegativeInteger(new long[]{-8, 2, 3, -6, 10}, 5, 2)));
    }

    public static long[] printFirstNegativeInteger(long[] A, int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>();
        long[] ans = new long[N - K + 1];
        //iterate first window
        for (int i = 0; i < K; i++) {
            //if number is negative, add to queue
            if (A[i] < 0) {
                queue.add(i);
            }
        }
        int counter = 0;
        //each iteration will be a separate window
        for (int i = K; i < N; i++) {
            //if queue was empty after current window, there were no negatives, add 0 to answer
            if (queue.isEmpty()) {
                ans[counter++] = 0L;
            } else {
                //negatives were found, add first negative in queue to ans
                ans[counter++] = A[queue.peek()];
            }
            //if queue is not empty and queue's head points to index which can't be part of next window, remove it
            if (!queue.isEmpty() && queue.peek() == i - K) {
                queue.remove();
            }
            //if subsequent array element is negative, add to queue
            if (A[i] < 0) {
                queue.add(i);
            }
        }   //for last window, if queue is empty add 0, else add element at queue head
            if (queue.isEmpty()) {
                ans[counter] = 0L;
            } else {
                ans[counter] = A[queue.peek()];
            }

        return ans;
    }
}