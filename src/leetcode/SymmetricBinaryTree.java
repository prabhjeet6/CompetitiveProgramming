package leetcode;

/***https://leetcode.com/problems/symmetric-tree/*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        }
        if (null == root1 || null == root2) {
            return false;
        }
        if (root1.val == root2.val) {

            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }
}