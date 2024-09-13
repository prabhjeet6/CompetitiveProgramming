package leetcode;


import java.util.HashMap;
import java.util.Map;

// Definition for a Node.


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class CopyListWithRandomPointer {
    public static void main(String[] as){
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node four=new Node(1);
        Node three=new Node(10);
        Node two=new Node(11);
        Node one=new Node(13);
        Node zero=new Node(7);

        zero.random=null;
        one.random=zero;
        two.random=four;
        three.random=two;
        four.random=zero;

        zero.next=one;
        one.next=two;
        two.next=three;
        three.next=four;

        System.out.println(copyRandomList(zero));


    }
    public static Node copyRandomList(Node head) {
        Node cloneHead = null;
        Node temp = head;
        Node prev = null;
        Map<Node, Node> originalToCloneMap = new HashMap<>();
        while (temp != null) {

            Node cloneCurrent = new Node(temp.val);
            originalToCloneMap.put(temp, cloneCurrent);
            if (cloneHead == null) {
                cloneHead = cloneCurrent;
                prev = cloneHead;

            } else {
                prev.next = cloneCurrent;
                prev=cloneCurrent;
            }
            temp = temp.next;
        }
        temp = head;
        Node cloneTemp = cloneHead;
        while (temp != null) {
            if (temp.random != null) {
                cloneTemp.random = originalToCloneMap.get(temp.random);
            }
            temp = temp.next;
            cloneTemp = cloneTemp.next;
        }
        return cloneHead;
    }
}
