package hackerearth;




// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.io.*;
import java.util.*;

class ConnectedComponents {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndE = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nAndE[0]);
        int e = Integer.parseInt(nAndE[1]);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= e; i++) {
            String[] uAndV = bufferedReader.readLine().split(" ");
            int u = Integer.parseInt(uAndV[0]);
            int v = Integer.parseInt(uAndV[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n + 1];
        int connectedComponents = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                visited[i]=true;
                dfs(visited, adj, i);
            }
        }

        System.out.print(connectedComponents);
    }

    static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int i) {
       /* if (visited[i]) {
            return;
        }*/
        //mark the element as visited
        visited[i] = true;
        for (int itr = 0; itr <adj.get(i ).size(); itr++) {
            if (!visited[adj.get(i ).get(itr)]) {
                //visited[adj.get(i ).get(itr)] = true;
                //call dfs for its neighbours
                dfs(visited, adj, adj.get(i ).get(itr));
            }
        }

    }
}
