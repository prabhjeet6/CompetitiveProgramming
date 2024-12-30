package leetcode.linkedlist;

import leetcode.ListNode;

class RotateList {

    public static void main(String[] a) {
        //[1,2,3,4,5]
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        rotateRight(one, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int n = count;
        if (head == null) {
            return null;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        temp = head;
        count = 0;
        ListNode prev = new ListNode(0);
        prev.next = temp;
        while (temp != null) {
            count++;
            if (count > (n - k)) {
                break;
            }
            prev = prev.next;
            temp = temp.next;
        }
        ListNode twistedHead = temp;
        if (temp != null) {
            prev.next = null;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
        }
        return twistedHead;
    }
}