package mockInterview;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/1682632/google-phone-screen-number-of-islands-in-a-tree
class Tree {
    Tree left;
    Tree right;
    int val;

    public Tree(Tree left, Tree right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

// 1 represents Land
// 0 represents water
public class NumberOfIslandsInTree {

    public static void main(String[] as) {
       /*
       Input for Diagram 1


        Tree l110 = new Tree(null, null, 0);
        Tree l111 = new Tree(null, null, 1);
        Tree l121 = new Tree(null, null, 1);
        Tree l120 = new Tree(null, null, 0);

        Tree l211 = new Tree(l110, l111, 1);
        Tree l210 = new Tree(l121, l120, 0);

        Tree root = new Tree(l211, l210, 0);

        Tree parent = new Tree(root, null, 0);*/

        //Parent is needed, since, looking at illustration 2 below, for example,
        //we can't identify a boundary, to bifurcate 0 and 1

        /*
        Input for Diagram 2

        Tree l111=new Tree(null,null,1);
        Tree l121=new Tree(null,null,1);
        Tree root=new Tree(l111,l121,1);
        Tree parent = new Tree(root, null, 0);*/

        //Input for Diag 3
        Tree l111=new Tree(null,null,1);
        Tree l121=new Tree(null,null,1);
        Tree root =new Tree(l111,l121,0);
        Tree parent = new Tree(root, null, 0);

         System.out.println(countNumberOfIslands(root,parent));
    }

    /*
     *         0                1          0
     *        / \              / \        / \
     *       1   0             1  1      1   1
     *      / \  /\
     *      0  1 1 0
     * */


    static int countNumberOfIslands(Tree root, Tree parent) {
        if (null == root) {
               return 0;
        }

        if (parent.val == 0 && root.val == 1) {
            if(null!=root.left &&null!=root.right) {
                return 1 + countNumberOfIslands(root.left, root)
                        + countNumberOfIslands(root.right, root);
            }else if(null!=root.left){
                return 1+countNumberOfIslands(root.left,root);
            }else {
                return 1+countNumberOfIslands(root.right,root);
            }
        }else {
            if(null!=root.left &&null!=root.right) {
                return  countNumberOfIslands(root.left, root)
                        + countNumberOfIslands(root.right, root);
            }else if(null!=root.left){
                return countNumberOfIslands(root.left,root);
            }else {
                return countNumberOfIslands(root.right,root);
            }
        }

    }

}
