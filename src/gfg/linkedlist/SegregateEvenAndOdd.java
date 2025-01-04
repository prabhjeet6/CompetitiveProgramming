package gfg.linkedlist;

//https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
class SegregateEvenAndOdd {
    Node even=null,odd=null,oddHead=null,evenHead=null;
    Node divide(Node head) {
        if(head==null){
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        if(temp.data%2==0){
            if(even==null){
                evenHead=temp;
                even=temp;
            }
            else{
                even.next=temp;
                even=even.next;
            }
        }
        else{
            if(odd==null){
                odd=temp;
                oddHead=temp;
            }
            else{
                odd.next=temp;
                odd=odd.next;
            }
        }
        divide(head);
        even.next=oddHead;
        return evenHead;
    }
}