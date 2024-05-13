package gfg;
/***https://www.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1*/
public class CountingLeaves
{
    int countLeaves(Node node)
    {
        if(null==node){
            return 0;
        } else if (null==node.left&&null==node.right){
            return 1;
        }else{
            return countLeaves(node.left)+countLeaves(node.right);
        }
    }
}
