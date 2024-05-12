package leetcode;

public class MergeTwoSortedLists {
    public static void main(String args[]) {


    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode head = null;
        //ListNode temp=null;
        ListNode tail = head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
            tail = head;
        } else {
            head = list2;
            list2 = list2.next;
            tail = head;
        }
       ListNode mergedList=mergeTwoLists(list1,list2);
       head.next=mergedList;
       return head;
    }
    public ListNode mergeTwoListsIteratively(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode head = null;
        //ListNode temp=null;
        ListNode tail = head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
            tail = head;
            //temp=head.next;
        } else {
            head = list2;
            list2 = list2.next;
            //temp=head.next;
            tail = head;
        }
        while (null != list1 && null != list2) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        if (null == list1) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return head;
    }
}
