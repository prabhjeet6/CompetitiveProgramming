package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeDiameter2 {
    public static void main(String args[]){
        Map<TreeNode,Integer> heightsMap=new HashMap<>();
        TreeNode four=new TreeNode();
        TreeNode five=new TreeNode();
        four.val=4;
        five.val=5;
        TreeNode two=new TreeNode(2,four,five);
        TreeNode three=new TreeNode();
        three.val=3;
        TreeNode root=new TreeNode(1,two,three);
        getHeight( root,  heightsMap);
        heightsMap.forEach((x,y)->{
            System.out.println(x.val+" -> "+y);
        });
        System.out.println( getDia( root,heightsMap));
    }

    static int getHeight(TreeNode root, Map<TreeNode,Integer> heightsMap){
        if(null==root){
           return 0;
        }
        int leftHeight=getHeight(root.left,heightsMap);
        int rightHeight=getHeight(root.right, heightsMap);
        int height=1+Math.max(leftHeight,rightHeight);
        heightsMap.put(root, height);
        return height;
    }
    static int getDia(TreeNode root,Map<TreeNode,Integer> heightsMap){
        if(null==root){
            return 0;
        }
        int leftDia=getDia(root.left,heightsMap);
        int rightDia=getDia(root.right,heightsMap);
        int biggerDia=Math.max(leftDia,rightDia);
        int height=0;
        if(null==root.left&&null==root.right){
            height=0;
        }
        else if(null==root.left){
           height= heightsMap.get(root.right);
        }else if(null==root.right){
            height= heightsMap.get(root.left);
        }else{
            height=heightsMap.get(root.left)+heightsMap.get(root.right);
        }
        return Math.max(height,biggerDia);
    }

}
