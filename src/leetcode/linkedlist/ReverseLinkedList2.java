package leetcode.linkedlist;

import leetcode.ListNode;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head, prevToLeft = null, rightNode = null, leftNode = null, patchNode = null;
        int count = 0;
        while (temp != null) {
            if (count == left - 1) {
                prevToLeft = temp;
            }
            if (count == right) {
                rightNode = temp;
            }
            count++;
            temp = temp.next;
        }
        if (prevToLeft != null)
            leftNode = prevToLeft.next;
        if (rightNode != null && rightNode.next != null) {
            patchNode = rightNode.next;
            rightNode.next = null;
        }
        recurse(leftNode);
        temp = leftNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        prevToLeft.next = leftNode;
        temp.next = patchNode;
        return head;
    }

    void recurse(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next;
        recurse(head.next);
    }

}
