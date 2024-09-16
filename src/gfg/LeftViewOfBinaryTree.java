package gfg;

//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class LeftViewOfBinaryTree {
    int maxLevelSoFar = -1;
    ArrayList<Integer> res = new ArrayList<>();

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        solve(root, 0);
        return res;
    }

    void solve(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevelSoFar) {
            res.add(root.data);
            maxLevelSoFar = level;
        }
        solve(root.left, level + 1);
        solve(root.right, level + 1);
    }

    ArrayList<Integer> leftViewIteratively(Node root) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        boolean isLevelFirstElementAdded=false;
        while (!queue.isEmpty()) {
            //queueSize does not determine the actual queue size, rather it determines,
            // size of queue at the start of a level
            int queueSize=queue.size();
            while(queueSize>0) {
                Node current = queue.remove();
                if(!isLevelFirstElementAdded) {
                    res.add(current.data);
                    isLevelFirstElementAdded=true;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                queueSize--;
            }
            isLevelFirstElementAdded=false;
        }
        return res;
    }
}