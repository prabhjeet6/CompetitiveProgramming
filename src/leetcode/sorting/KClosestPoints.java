package leetcode.sorting;

import java.util.PriorityQueue;

class KClosestPoints {
    public static class Points implements Comparable<Points>{
        int x,y,d;
        public Points(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
        public int compareTo(Points p2){
            return this.d-p2.d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int ans[][]=new int[k][2];
        PriorityQueue<Points> pq=new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            pq.add(new Points(points[i][0], points[i][1], points[i][0]*points[i][0]+points[i][1]*points[i][1]));
        }
        for(int i=0;i<k;i++){
            Points c=pq.remove();
            ans[i][0]=c.x;
            ans[i][1]=c.y;
        }
        return ans;
    }
}