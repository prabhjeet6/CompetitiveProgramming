package leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodesInPairs {
    public static void main(String a[]){
        ListNode four=new ListNode(4,null);
        ListNode three=new ListNode(3,four);
        ListNode two=new ListNode(2,three);
        ListNode one=new ListNode(1,two);
        System.out.println(swapPairsIterative2(one));
    }

    public static ListNode swapPairs(ListNode head) {
        // if head.next is null, which node will you swap head with
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public static ListNode swapPairsIterative2(ListNode head) {

        ListNode prevNode = new ListNode(0);    //Node situated before the two to-be-swapped nodes
        prevNode.next = head;                   //Starting before head
        ListNode newHead = prevNode;            //Storing a reference for returning

        while(prevNode.next!=null && prevNode.next.next!=null){

            //Declare                                           // ...[prev]-->[node1]-->[node2]-->[next]...
            ListNode node1 = prevNode.next;
            ListNode node2 = node1.next;
            ListNode nextNode = node2.next;

            //Swap
            prevNode.next = node2;                              // ...[prev]-->[node2]<--[node1]   [next]...
            node2.next = node1;                                 // ...[prev]-->[node2]<-->[node1]  [next]...
            node1.next = nextNode;                              // ...[prev]-->[node2]-->[node1]-->[next]...

            //Move
            prevNode = node1;                                   // ...[...]-->[node2]-->[node1/prev]-->[next]...
        }

        return newHead.next;
    }
}
