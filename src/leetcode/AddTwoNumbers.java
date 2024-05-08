package leetcode;

import java.io.IOException;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {
    public static void main(String args[]) throws IOException {
        ListNode l1 = new ListNode(9, null);
        ListNode l2 = new ListNode(9, null);
        ListNode l3 = new ListNode(9, null);
        ListNode l4 = new ListNode(9, null);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        ListNode r1 = new ListNode(9, null);
        ListNode r2 = new ListNode(9, null);
        ListNode r3 = new ListNode(9, null);
        ListNode r4 = new ListNode(9, null);
        ListNode r5 = new ListNode(9, null);
        ListNode r6 = new ListNode(9, null);
        ListNode r7 = new ListNode(9, null);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = r6;
        r6.next = r7;
        new AddTwoNumbers().addTwoNumbers(l1, r1);

    }

    int getCarry(int val1, int val2, int carry) {
        if (val1 + val2 + carry >= 10) {
            return 1;
        } else {
            return 0;
        }
    }

    //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //Output: [8,9,9,9,0,0,0,1]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else if (null == l1 && null == l2) {
            return null;
        } else {
            ListNode temp1 = l1;
            ListNode temp2 = l2;
            int sizeOfFirstLinkedList = 0, sizeOfSecondLinkedList = 0;
            while (null != temp1) {
                temp1 = temp1.next;
                sizeOfFirstLinkedList++;
            }
            while (null != temp2) {
                temp2 = temp2.next;
                sizeOfSecondLinkedList++;
            }
            int numberOfInclusiveIterations = Math.min(sizeOfFirstLinkedList, sizeOfSecondLinkedList);
            int numberOfTotalIterations = Math.max(sizeOfFirstLinkedList, sizeOfSecondLinkedList);
            temp1 = l1;
            temp2 = l2;
            ListNode temp = null;
            int carry = 0, val = 0;
            for (int i = 1; i <= numberOfTotalIterations; i++) {

                if (i <= numberOfInclusiveIterations) {
                    val = (temp1.val + temp2.val + carry) % 10;
                    carry = getCarry(temp1.val, temp2.val, carry);
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                } else {
                    if (null == temp1 && null != temp2) {
                        val = (temp2.val + carry) % 10;
                        carry = getCarry(0, temp2.val, carry);
                        temp2 = temp2.next;
                    }
                    if (null == temp2 && null != temp1) {
                        val = (temp1.val + carry) % 10;
                        carry = getCarry(temp1.val, 0, carry);
                        temp1 = temp1.next;
                    }
                }

                ListNode node = new ListNode(val, null);
                if (null == head) {
                    head = node;
                    temp = node;
                    temp.next = null;
                } else {
                    temp.next = node;
                    temp = temp.next;
                }

            }
            if(carry!=0){
                ListNode node = new ListNode(carry, null);
                temp.next = node;
                temp = temp.next;
            }
        }

        return head;
    }


}
