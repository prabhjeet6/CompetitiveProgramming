package leetcode;


// Definition for singly-linked list.


public class MiddleNode {
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
        //System.out.println(head);
        System.out.println(middleNode(head));

    }
    public static ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int count=1,middleIndex=0;
        while(temp.next!=null){
            count++;
            temp=temp.next;

        }
        middleIndex=count/2;
        temp=head;
        while(middleIndex!=0){
            middleIndex--;
            temp=temp.next;
        }
        return temp;
    }
    public static ListNode middleNodeOnePass(ListNode head) {
        ListNode slowTemp=head;
        ListNode fastTemp=head;
        //int count=1,middleIndex=0;
        while(fastTemp!=null||fastTemp.next!=null){
            //count++;
            slowTemp=slowTemp.next;
            fastTemp=fastTemp.next.next;

        }
        /*middleIndex=count/2;
        temp=head;
        while(middleIndex!=0){
            middleIndex--;
            temp=temp.next;
        }*/
        return slowTemp;
    }

}
