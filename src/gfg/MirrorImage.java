package gfg;

/***https://www.geeksforgeeks.org/problems/mirror-tree/1*/
class MirrorImage {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if(null==node){
            return;
        }
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
        mirror(node.left);
        mirror(node.right);
    }
}