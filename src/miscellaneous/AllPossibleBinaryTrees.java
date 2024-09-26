package miscellaneous;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AllPossibleBinaryTrees {
    //BruteForce; Has overlapping SubProblems; refer notes/lecture
    List<TreeNode> allPossibleBinaryTreesBruteForce(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(null);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            List<TreeNode> leftSubTrees = allPossibleBinaryTreesBruteForce(i);
            List<TreeNode> rightSubTrees = allPossibleBinaryTreesBruteForce(n - i - 1);
            for (int j = 0; j < leftSubTrees.size(); j++) {
                for (int k = 0; k < rightSubTrees.size(); k++) {
                    ans.add(new TreeNode(0, leftSubTrees.get(j), rightSubTrees.get(k)));
                }
            }
        }
        return ans;
    }

    //For optimised version of AllPossibleBinaryTrees, refer to AllPossibleFullBinaryTree, which
    //is a DP + Backtracking approach, except for an if condition
}

