package leetcode;


import java.util.Map;

public class BinaryTreeDiameter1 {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeAppoach1(root);
    }

    int diameterOfBinaryTreeAppoach1(TreeNode root){
        if(null==root){
            return 0;
        }
        int leftDia=diameterOfBinaryTreeAppoach1(root.left);
        int rightDia=diameterOfBinaryTreeAppoach1(root.right);
        int biggerDiameter=Math.max(leftDia,rightDia);
        //here, height does not add 1 as we are counting number of edges
        int height=getHeight(root.left)+getHeight(root.right);
        return Math.max(biggerDiameter,height);
    }
    public int getHeight(TreeNode root) {
        if(null==root){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }


}