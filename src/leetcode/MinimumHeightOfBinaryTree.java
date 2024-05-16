package leetcode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/****https://leetcode.com/problems/minimum-depth-of-binary-tree/*/
public class MinimumHeightOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(null==root){
            return 0;
        }
        int lstHeight=minDepth(root.left);
        int hstHeight=minDepth(root.right);
        if(lstHeight==0&&hstHeight!=0){
            return 1+ hstHeight;
        }
        else if(lstHeight!=0&&hstHeight==0){
            return 1+ lstHeight;
        } else{
            return 1+Math.min(lstHeight,hstHeight);
        }
    }

}