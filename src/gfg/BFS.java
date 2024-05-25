package gfg;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    // Function to return Breadth First Traversal of given graph.

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> traversal=new ArrayList<Integer>();
        Queue<Integer> queue=new LinkedList<Integer>();
        boolean visited[]=new boolean[V];
        //traversal.add(0);
        visited[0]=true;
        queue.add(0);
        //for(int i=0;i<V;i++){
        //if(!visited[i]){


        while(!queue.isEmpty()){

            int current=queue.poll();
            traversal.add(current);
            //for(List<Integer> list:adj){
            for(Integer element:adj.get(current)){
                if(!visited[element]){
                    queue.add(element);
                    visited[element]=true;
                }
            }
            //}

        }
        //}
        //}
        return traversal;
    }
}
