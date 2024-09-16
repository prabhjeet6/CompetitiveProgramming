package gfg;

//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

import java.util.ArrayList;

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
}