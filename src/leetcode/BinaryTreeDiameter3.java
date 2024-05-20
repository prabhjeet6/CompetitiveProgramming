package  leetcode;
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
class Pair{
    int height;

    public Pair(int height, int diameter) {
        this.height = height;
        Diameter = diameter;
    }

    int Diameter;

}
class BinaryTreeDiameter3 {
    public int diameterOfBinaryTree(TreeNode root) {
        return getDia3(root).Diameter;
    }
    Pair getDia3(TreeNode root){

        if(null==root){
            return new Pair(0,0);
        }
        Pair leftSubTree=getDia3(root.left);
        Pair rightSubTree=getDia3(root.right);
        int height=1+Math.max(leftSubTree.height,rightSubTree.height);
        int biggerDia=Math.max(leftSubTree.Diameter,rightSubTree.Diameter);
        int diameter=Math.max(height,biggerDia);
        return new Pair(leftSubTree.height+rightSubTree.height,diameter);
    }
}