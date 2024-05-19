package leetcode;

import com.sun.source.tree.Tree;

public class BalancedBinaryTree {
    public static void main(String args[]){
        TreeNode four=new TreeNode(4, null,null);
        TreeNode three=new TreeNode(3, four,null);
        TreeNode four1=new TreeNode(4, null,null);
        TreeNode three1=new TreeNode(3, three,four1);
        TreeNode two=new TreeNode(2, three1,null);

        TreeNode three2=new TreeNode(3, null,null);
        TreeNode two1=new TreeNode(2, null,three2);

        TreeNode one=new TreeNode(1,two,two1);

        System.out.println(isBalanced(one));

    }

    public static  boolean isBalanced(TreeNode root) {
        if(null==root){
            return true;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        //find isBalanced for current node
        if(Math.abs(leftHeight-rightHeight)>1){
            return false;
        }
        //recurse, to check for other nodes
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    static int getHeight(TreeNode root){
        if(null==root){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
