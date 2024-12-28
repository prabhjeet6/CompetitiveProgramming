package leetcode.linkedlist;

import leetcode.ListNode;

public class MergeInBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null) return null;
        ListNode temp = list1;
        int count = 0;
        while (temp != null) {
            if (count == a - 1) {
                break;
            }
            temp = temp.next;
            count++;
        }
        ListNode prevToA = temp;
        ListNode bthNode = null;
        while (temp != null) {
            if (count == b) {
                break;
            }
            temp = temp.next;
            count++;
        }
        bthNode = temp;
        prevToA.next = list2;
        temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = bthNode.next;
        return list1;
    }
}
