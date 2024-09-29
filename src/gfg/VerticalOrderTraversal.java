package gfg;

import java.util.*;

class VerticleOrderTraversal {
    //SC O(N) TC O(N)
    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //Map to store the column-wise nodes
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeAndColumnNumber> queue = new LinkedList<>();


        queue.offer(new NodeAndColumnNumber(root, 0));
        while (!queue.isEmpty()) {
            NodeAndColumnNumber nodeAndColumnNumber = queue.poll();
            Node current = nodeAndColumnNumber.node;
            int columnNumber = nodeAndColumnNumber.columnNumber;
            if (!map.containsKey(columnNumber)) {
                map.put(columnNumber, new ArrayList<>());
            }
            map.get(columnNumber).add(current.data);

            if (current.left != null) {
                queue.offer(new NodeAndColumnNumber(current.left, columnNumber - 1));
            }
            if (current.right != null) {
                queue.offer(new NodeAndColumnNumber(current.right, columnNumber + 1));
            }

        }
        //Traverse the map and add the nodes to the result list
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> nodes = entry.getValue();
            result.addAll(nodes);
        }

        return result;

    }
}

class NodeAndColumnNumber {
    Node node;
    int columnNumber;

    public NodeAndColumnNumber(Node node, int columnNumber) {
        this.node = node;
        this.columnNumber = columnNumber;
    }
}