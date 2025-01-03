package leetcode.linkedlist;

import leetcode.ListNode;

public class InsertionSortINLinkedList {

    //Input: -1,5,3,4,0
    //Expected Output: -1,0,3,4,5
    //Output: -1,0,5
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode sortedHead = null, itr = head, temp = null;

        while (itr != null) {
            temp = itr;
            itr = itr.next;
            temp.next = null;
            if (sortedHead == null) {
                sortedHead = temp;
            } else {
                if (temp.val < sortedHead.val) {
                    temp.next = sortedHead;
                    sortedHead = temp;
                } else {
                    boolean isInserted = false;
                    ListNode prev = new ListNode();
                    prev.next = sortedHead;
                    ListNode sortedHeadItr = sortedHead;
                    while (sortedHeadItr != null) {
                        if (temp.val < sortedHeadItr.val) {
                            isInserted = true;
                            prev.next = temp;
                            temp.next = sortedHeadItr;
                            break;
                        }
                        sortedHeadItr = sortedHeadItr.next;
                        prev = prev.next;
                    }
                    if (!isInserted) {
                        prev.next = temp;
                    }
                }
            }
        }
        return sortedHead;
    }

    public ListNode insertionSortListOptimized(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            ListNode prev = dummy;
            //keep moving till the array is sorted
            //current represents the node of the sorted sublist and prev.next represents node moving
            //ahead till current is larger compared to nodes in the input list
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            //when current is smaller, it is in the correct index in place
            current.next = prev.next;
            prev.next = current;
            current = nextNode;
        }
        return dummy.next;
    }
}
