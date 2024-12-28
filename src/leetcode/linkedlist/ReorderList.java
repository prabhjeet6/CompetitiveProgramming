package leetcode.linkedlist;

import leetcode.ListNode;

public class ReorderList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public void reorderList(ListNode head) {
        ListNode temp = head;
        while (null != temp.next) {
            temp = temp.next;
        }
        ListNode tail = temp;
        recurse(head, tail);
    }

    private void recurse(ListNode head, ListNode tail) {
        if (null == head) {
            return;
        }
        ListNode nextHead = head.next;
        head.next = tail;
        ListNode nextItr = nextHead;
        ListNode nextTail = null;
        while (null != nextItr && null != nextItr.next) {

            if (null == nextItr.next.next) {
                nextTail = nextItr;
                nextTail.next = null;
            }
            nextItr = nextItr.next;
        }
        if (null != tail) {
            tail.next = nextHead;
        }
        recurse(nextHead, nextTail);

    }

}
