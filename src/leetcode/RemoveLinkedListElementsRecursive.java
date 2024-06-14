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
class RemoveLinkedListElementsRecursive1 {

    public ListNode removeElements(ListNode head, int val) {
        if(null==head){
            return head;
        }
        if(head.val==val){
            return removeElements(head.next,val);
        }
        ListNode node=head;
        ListNode parent=new ListNode();
        return remove(head,node,parent,val);
    }
    ListNode remove(ListNode head,ListNode node,ListNode parent,int val){
        if(null==node){
            return head;
        }
        if(null==node.next&&node.val==val){
            node=null;
            parent.next=node;
            return head;
        }
        if(node.val==val){
            parent.next=node.next;
            node=parent.next;
            return remove(head,node,parent,val);
        }
        return remove(head,node.next,node,val);
    }
}
public class RemoveLinkedListElementsRecursive {
    public static void main(String arg[]){
        //[1,2,6,3,4,5,6]
        ListNode node7=new ListNode(6,null);
        ListNode node6=new ListNode(5,node7);
        ListNode node5=new ListNode(4,node6);
        ListNode node4=new ListNode(3,node5);
        ListNode node3=new ListNode(6,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        System.out.println(removeElements(node1,6));


    }

    public static ListNode removeElements(ListNode head, int val) {
        //[1,2,6,3,4,5,6]
        if(null==head){
            return head;
        }
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }
        return head;
    }
}