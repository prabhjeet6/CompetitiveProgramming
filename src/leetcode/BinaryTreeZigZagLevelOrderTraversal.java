package leetcode;


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreeZigZagLevelOrderTraversal {
    public static void main(String[] as) {
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode twenty = new TreeNode(20, fifteen, seven);

        TreeNode three = new TreeNode(3, nine, twenty);
        System.out.println(zigzagLevelOrder(three));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);

        Stack<TreeNode> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            //queueSize is calculated at every level and does not indicate the number of elements in queue
            //at some in time
            while (queueSize > 0) {
                TreeNode current = queue.remove();
                if (level % 2 == 0) {
                    levelRes.add(current.val);
                } else {
                    stack.push(current);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                queueSize--;
            }
            while (!stack.isEmpty()) {
                levelRes.add(stack.pop().val);
            }
            res.add(levelRes);
            level++;
        }

        return res;
    }
}
