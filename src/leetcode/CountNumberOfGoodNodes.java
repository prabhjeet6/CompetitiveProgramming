package leetcode;
//https://leetcode.com/problems/count-the-number-of-good-nodes/

import java.util.ArrayList;
import java.util.List;

class CountNumberOfGoodNodes {
    public int ans;

    public void graph(List<List<Integer>> list, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            //because, it is undirected graph, putting nodes in each other's adjList
            list.get(arr[i][0]).add(arr[i][1]);
            list.get(arr[i][1]).add(arr[i][0]);
        }
    }

    public int dfs(List<List<Integer>> list, int curr, int p) {
        boolean isGood = true;
        int check = -1;

        //calculating total nodes is needed as you will need to calculate total left and right nodes at each
        //recursive dfs call as on line 32
        int totalNode = 0;
        for (int i = 0; i < list.get(curr).size(); i++) {
            int n = list.get(curr).get(i);
            //since, adjList of n contains p, and adjList of p contains n
            if (n == p) {
                continue;
            }
            //recurse for  bottom most node
            int currSize = dfs(list, n, curr);

            if (check == -1) {
                //if check is set to a default value, give it the value calculated above
                check = currSize;
            } else if (check != currSize) {
                //In the next iteration of for loop, ith child of current Node
                //must have total children equal to that of currSize, otherwise it is not a good
                //node
                isGood = false;
            }
            //total nodes adds currSize irrespective of the current node being good, as it has to calculate total nodes
            //for its parent
            totalNode += currSize;
        }
        if (isGood) {
            ans++;
        }
        // because parent needs total nodes of the child and the child itself as all these nodes come under the parent node
        return totalNode + 1;
    }

    public int countGoodNodes(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            list.add(new ArrayList<>());
        }
        graph(list, edges);
        ans = 0;
        dfs(list, 0, -1);
        return ans;
    }
}