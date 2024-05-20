package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(null==root){
            return result;
        }
        Queue<TreeNode> queue=new ConcurrentLinkedQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize=queue.size();
            List<Integer> levelList=new ArrayList<>();
            while(queueSize>0){
                queueSize--;
                TreeNode node=queue.poll();
                levelList.add(node.val);
                if(null!=node.left){
                    queue.add(node.left);
                }
                if(null!=node.right){
                    queue.add(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}