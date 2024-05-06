package leetcode;
/***https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/*/
public class DeleteNthNodeFromEnd {
    public static void main(String args[]){

        ListNode head = new ListNode(1, null);
        ListNode temp=head;
        int counter=2;
        while(counter!=6) {
            ListNode node = new ListNode(counter, null);
            temp.next=node;
            temp=node;
            counter++;
        }
        System.out.println(head);
        System.out.println(deleteNthNodeFromEnd(head,2));

    }

    private static ListNode deleteNthNodeFromEnd(ListNode head,int n) {
        ListNode temp=head;
        int count=0;
        while(null!=temp){
            count++;
            temp=temp.next;
        }
        System.out.println("count"+count);
        if(count-n==0){
            head=head.next;
        }else{
            temp=head;
            // 1 2 3 4 5
            for(int i=0;i<count-n-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        return head;
    }
}
