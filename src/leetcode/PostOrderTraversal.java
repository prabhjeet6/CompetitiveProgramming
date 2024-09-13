package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    List<Integer> traversal = new ArrayList<Integer>();

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if (null == root) {
            return traversal;
        }

        postorderTraversalRecursive(root.left);

        postorderTraversalRecursive(root.right);
        traversal.add(root.val);
        return traversal;
    }

    //Recursion uses System Stack, since we are implementing PostOrder(Left|Right|Root) iteratively,
    // and using stack(LIFO) to mimic the behaviour, we first insert root, then right and then left
    public List<Integer> postOrderTraversalIterativeUsingStackAndFlag(TreeNode root) {
        Stack<Flag> stack = new Stack<>();
        List<Integer> traversal = new ArrayList<Integer>();
        if (null == root) {
            return traversal;
        }
        stack.push(new Flag(root, false));
        while (!stack.isEmpty()) {
            Flag flag = stack.pop();


            if (!flag.isVisitedBefore) {
                flag.isVisitedBefore = true;
                stack.push(flag);
                if (flag.node.right != null) {
                    stack.push(new Flag(flag.node.right, false));

                }

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
