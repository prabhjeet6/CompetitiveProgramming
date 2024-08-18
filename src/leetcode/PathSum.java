package leetcode;

//https://leetcode.com/problems/path-sum/

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
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);

    }
}
