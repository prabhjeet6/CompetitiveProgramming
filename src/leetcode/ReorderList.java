package leetcode;


import java.util.HashMap;
import java.util.Map;

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
class ReorderList {
    public static void main(String as[]) {
        ReorderList reorderList = new ReorderList();
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        reorderList.reorderList(one);
        System.out.println(one);
    }


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
