package gfg;


import java.util.ArrayList;
import java.util.List;

class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<Integer>();
        dfs(0,visited,ans,adj);
        return ans;
    }
    public void dfs(int start, boolean visited[], List<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        visited[start]=true;
        ans.add(start);

        for(int i=0;i<adj.get(start).size();i++){
            if(!visited[adj.get(start).get(i)]){
                dfs(adj.get(start).get(i),visited,ans,adj);
            }
        }

    }
}