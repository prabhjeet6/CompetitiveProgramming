package leetcode;
//https://www.youtube.com/watch?v=D2vI2DNJGd8
public class ReverseListIteratively {
    public static ListNode reverseList(ListNode head) {
      if(null==head){
         return head;
      }
     ListNode prev=null;
     ListNode current=head;
     //dry run to understand this: prev is a fictional node taken before head to invert pointers
     while(null!=current){
         ListNode temp=current.next;
         current.next=prev;
         prev=current;
         current=temp;
     }
     head=prev;
     return head;
    }
    public static ListNode reverseListRecursively(ListNode head) {
        if(null==head.next||null==head){
            return head;
        }
        ListNode temp=head.next;
        head.next=null;
        ListNode p=reverseListRecursively(temp);
        temp.next=head;
        return p;
    }
    public static void main(String args[]){

        ListNode head = new ListNode(1, null);
        ListNode temp=head;
        int counter=2;
        while(counter!=3) {
            ListNode node = new ListNode(2, null);
            temp.next=node;
            temp=node;
            counter++;
        }
        System.out.println(head);
        System.out.println(reverseList(head));

    }

}
