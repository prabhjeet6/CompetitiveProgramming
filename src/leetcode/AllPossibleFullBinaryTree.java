package leetcode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/all-possible-full-binary-trees/

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
//Backtracking + DP
class AllPossibleFullBinaryTree {
    public List<TreeNode> allPossibleFBT(int n) {
        List<List<TreeNode>> res = calculate(n);
        return res.get(n);
    }

    public List<List<TreeNode>> calculate(int n) {
        List<List<TreeNode>> ans = new ArrayList<List<TreeNode>>();

        ans.add(null); // this is for 0 n

        List<TreeNode> oneCase = new ArrayList<>();
        oneCase.add(new TreeNode(0, null, null));

        ans.add(oneCase);             // this is for n = 1


        for (int i = 2; i <= n; i++) {

            List<TreeNode> res = new ArrayList<>();

            for (int j = 1; j < i; j++) {

                if (j % 2 != 0 && (i - 1 - j) % 2 != 0) {
                    List<TreeNode> lst = ans.get(j);
                    List<TreeNode> rst = ans.get(i - 1 - j);

                    for (int k = 0; k < lst.size(); k++) {
                        for (int l = 0; l < rst.size(); l++) {
                            res.add(new TreeNode(0, lst.get(k), rst.get(l)));
                        }
                    }
                }
            }
            ans.add(res);
        }
        return ans;
    }
}

