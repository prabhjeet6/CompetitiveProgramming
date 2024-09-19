package leetcode;

//https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {
    static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        solve(root);
        return sum;
    }

    static void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
    }

    public static void main(String[] asd) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);
        System.out.println(sumOfLeftLeaves(one));

    }
}
