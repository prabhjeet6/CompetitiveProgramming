package gfg;
//https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class RightViewOfBinaryTree {
    int maxLevelSoFar = -1;
    ArrayList<Integer> res = new ArrayList<>();

    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
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
        solve(root.right, level + 1);
        solve(root.left, level + 1);


    }
    ArrayList<Integer>  rightViewIteratively(Node root) {
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
                //For right view, instead of the left child, we check for right child first,
                //in case, right child is not present, we look for left child
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                queueSize--;
            }
            isLevelFirstElementAdded=false;
        }
        return res;
    }
}
