package gfg;

public class CountNodesInBST {
    public static void main(String args[]){
        Node one=new Node(1);
        Node forty=new Node(40);
        Node hundred=new Node(100);
        Node five =new Node(5);
        Node fifty=new Node(50);
        Node ten=new Node(10);
        five.left=one;
        fifty.left=forty;
        fifty.right=hundred;
        ten.left=fifty;
        ten.right=fifty;
        System.out.println(getCount(ten,5,45));

    }


        static  int getCount(Node root,int l, int h){

            if(null==root){
                return 0;
            }

            if(root.data >= l && root.data <= h)
                return 1 + getCount(root.left, l, h)+
                        getCount(root.right, l, h);
            else if(root.data < l) {
                return getCount(root.right,l,h);
            }
            else {
                return  getCount(root.left, l, h);
            }
        }
    }




class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
