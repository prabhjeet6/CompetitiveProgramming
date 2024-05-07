package leetcode;

import java.math.BigInteger;
import java.util.List;

public class DoubleANumberRepresentedAsLinkedList {
    public static void main(String args[]){

        ListNode head = new ListNode(9, null);
        ListNode temp=head;
        int counter=2;
        while(counter!=4) {
            ListNode node = new ListNode(9, null);
            temp.next=node;
            temp=node;
            counter++;
        }
        //System.out.println(head);
        System.out.println(doubleALinkedList(head));

    }

    private static ListNode doubleALinkedList(ListNode head) {
        if(null==head){
            return head;
        }
        ListNode temp=head;
        String value="";
        while(null!=temp){
            value+=temp.val;
            temp=temp.next;
        }
        temp=head;
        boolean newNodeNeeded=false;
        String neededResultant=String.valueOf(new BigInteger(value.trim()).multiply(BigInteger.TWO));
        for(int i=0;i<neededResultant.length();i++){
            int data=Integer.parseInt(String.valueOf(neededResultant.charAt(i)));
            if(null!=temp&&!newNodeNeeded) {
                temp.val = data;
                if (null != temp.next) {
                    temp = temp.next;
                } else {
                    newNodeNeeded=true;
                    continue;
                }
            }
            if(newNodeNeeded){
                ListNode node = new ListNode(data, null);
                temp.next = node;
                temp = node;
            }
        }
    return head;
    }
}
