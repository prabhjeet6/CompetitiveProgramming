package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    List<Integer> traversal = new ArrayList<Integer>();

    //TC:O(N) SC:O(H)
    public List<Integer> preorderTraversalRecursive(TreeNode root) {

        if (null == root) {
            return traversal;
        }
        traversal.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
        return traversal;
    }

    //Recursion uses System Stack, since we are implementing PreOrder(Root|Left|Right) iteratively,
    // and using stack(LIFO) to mimic the behaviour, we first insert root, then right and then left
   //TC:O(N) SC:O(H)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (null == root) {
            return traversal;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.pop();
            traversal.add(topNode.val);
            if (topNode.right != null) {
                stack.push(topNode.right);
            }
            if (topNode.left != null) {
                stack.push(topNode.left);
            }
        }

        return traversal;
    }
}
