package leetcode;

import java.util.*;

//https://leetcode.com/problems/k-th-nearest-obstacle-queries/
public class KthNearestObstacleQueries {

    //since a queue returns peek element instead of kth index as in the case of Brute force solution,
    //and as we need the kth farthest obstacle  everytime(kth largest number), hence, we use max heap
    //priority queue to get the biggest number first when calling peek()
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] results = new int[n];
        //Max Heap
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int ithDistance = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            priorityQueue.add(ithDistance);

            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
            results[i]=priorityQueue.size()==k?priorityQueue.peek():-1;
        }
        return results;
    }
    //TLE at TestCae 586
    public int[] resultsArrayBruteForce(int[][] queries, int k) {
        int n = queries.length;
        int[] results = new int[n];
        List<Integer> list=new ArrayList<>(k);
        for (int i = 0; i < n; i++) {
            int ithDistance = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            list.add(ithDistance);
            Collections.sort(list);
            if(list.size()>k){
                list.removeLast();
            }
            results[i]=list.size()==k?list.get(k-1):-1;
        }
        return results;
    }
}
