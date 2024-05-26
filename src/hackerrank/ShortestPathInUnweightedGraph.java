package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem*/
public class ShortestPathInUnweightedGraph {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfQueries = Integer.parseInt(bufferedReader.readLine());
        while (numberOfQueries > 0) {
            String[] nodesAndEdges = bufferedReader.readLine().split(" ");
            int numberOfNodes = Integer.parseInt(nodesAndEdges[0]);
            int numberOfEdges = Integer.parseInt(nodesAndEdges[1]);
            List<List<Integer>> ajacencyList = new ArrayList<>();
            for (int i = 1; i <= numberOfNodes + 1; i++) {
                ajacencyList.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < numberOfEdges; i++) {
                String[] fromAndTo = bufferedReader.readLine().split(" ");
                int from = Integer.parseInt(fromAndTo[0]);
                int to = Integer.parseInt(fromAndTo[1]);

                ajacencyList.get(from).add(to);
                ajacencyList.get(to).add(from);

            }
            int sourceNode = Integer.parseInt(bufferedReader.readLine());
            LinkedList<Integer> queue = new LinkedList<>();
            boolean visited[] = new boolean[numberOfNodes + 1];
            queue.add(sourceNode);
            int[] distance = new int[numberOfNodes + 1];
            Arrays.fill(distance, -1);
            distance[sourceNode] = 0;
            visited[sourceNode] = true;
            while (!queue.isEmpty()) {
                int currentNode = queue.remove();
                if (null != ajacencyList.get(currentNode)) {
                    for (Integer element : ajacencyList.get(currentNode)) {
                        if (!visited[element]) {
                            queue.add(element);
                            visited[element]=true;
                        /*if (element) {
                            distance[element ] = 6;
                        } else*/
                            distance[element] = distance[currentNode] + 6;
                        }
                    }
                }

            }
            for (int i = 1; i < numberOfNodes + 1; i++) {
                if (i != sourceNode) {
                    System.out.print(distance[i] + " ");
                }
            }
            numberOfQueries--;
        }


    }
}
