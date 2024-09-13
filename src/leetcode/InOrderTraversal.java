package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Flag {
    TreeNode node;
    boolean isVisitedBefore;

    public Flag(TreeNode node, boolean isVisitedBefore) {
        this.node = node;
        this.isVisitedBefore = isVisitedBefore;
    }
}

public class InOrderTraversal {

    List<Integer> traversal = new ArrayList<Integer>();


    public List<Integer> inorderTraversalRecusive(TreeNode root) {
        if (null == root) {
            return traversal;
        }

        inorderTraversalRecusive(root.left);
        traversal.add(root.val);
        inorderTraversalRecusive(root.right);
        return traversal;
    }

    //Recursion uses System Stack, since we are implementing InOrder(Left|Root|Right) iteratively,
    // and using stack(LIFO) to mimic the behaviour, we first insert right, then root and then left
    public List<Integer> inorderTraversalIterativeUsingStackAndFlag(TreeNode root) {
        Stack<Flag> stack = new Stack<>();
        List<Integer> traversal = new ArrayList<Integer>();
        if (null == root) {
            return traversal;
        }
        stack.push(new Flag(root, false));
        while (!stack.isEmpty()) {
            Flag flag = stack.pop();
            if (!flag.isVisitedBefore) {
                if (flag.node.right != null) {
                    stack.push(new Flag(flag.node.right, false));

                }
                flag.isVisitedBefore = true;
                stack.push(flag);
                if (flag.node.left != null) {
                    stack.push(new Flag(flag.node.left, false));
                }
            } else {
                traversal.add(flag.node.val);
            }
        }
        return traversal;
    }

}
