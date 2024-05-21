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
class KthSmallestElementInBST {
    int count=0,ans=0;
    TreeNode parent=null;
    public int kthSmallest(TreeNode root, int k) {
        if(null==root){
            //return
        }
        if(null!=root.left){
            kthSmallest(root.left,k);
        }
        count++;
        if(count==k){
            ans= root.val;
        }
        if(null!=root.right){
            kthSmallest(root.right,k);
        }
        return ans;

    }
}
