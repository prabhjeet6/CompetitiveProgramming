package leetcode;


import java.util.*;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

public class FlattenBinaryTreeToLinkedList {

    //https://www.youtube.com/watch?v=NOKVBiJwkD0
    //TC:O(N) SC:O(H)
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Store current node's left and right
        TreeNode left = root.left;
        TreeNode right = root.right;
        //mark node's left to null
        root.left = null;
        // Make pre Order traversal
        flatten(left);
        flatten(right);

        // After the traversal, attach right of node  to variable 'left'
        root.right = left;

        //go to the bottom most node of node's right(as it is pointing to variable 'left'
        // and your seq should be root-> left-> right, hence, you need to know the right most
        // part of the node's right)
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        //attach 'right' to node's right
        cur.right = right;
    }


    //https://www.youtube.com/watch?v=sWf7k1x9XR4&t=45s
    //TC:O(N) SC:O(H)
    public void flatten3(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            curr.right = stack.peek();
            curr.left = null;
        }
    }

    //Morris Traversal TC:O(N) SC:O(1)
    public void flatten2(TreeNode root) {

    }

    //PPA Approach
    public void flatten4(TreeNode root) {
        solve(root);
    }

    NodePair solve(TreeNode root) {
        if (root == null) {
            return new NodePair(null, null);
        }
        TreeNode head = root;
        TreeNode tail = root;
        NodePair leftSubTree = solve(root.left);
        NodePair rightSubTree = solve(root.right);

        root.right = leftSubTree.linkedListHead;
        root.left = null;


        if (leftSubTree.linkedListTail != null) {
            if (rightSubTree.linkedListHead != null) {
                //if leftSubtree and rightSubtree exist
                leftSubTree.linkedListTail.right = rightSubTree.linkedListHead;
                tail = rightSubTree.linkedListTail;
            } else {
                //if leftSubtree exists, but, right subtree does not exist
                leftSubTree.linkedListTail.right = null;
                tail = leftSubTree.linkedListTail;
            }
        } else {
            if (rightSubTree.linkedListHead != null) {
                // if leftSubtree does not exist but right subtree exists
                root.right = rightSubTree.linkedListHead;
                tail = rightSubTree.linkedListTail;
            }
        }
        return new NodePair(head, tail);
    }


}

class NodePair {
    TreeNode linkedListHead;
    TreeNode linkedListTail;

    public NodePair(TreeNode o, TreeNode o1) {
        this.linkedListHead = o;
        this.linkedListTail = o1;
    }
}