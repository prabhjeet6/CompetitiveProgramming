package leetcode;

//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class KSortedLists {
    //TC:O(N * K^2)
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode listHead : lists) {
            ans = mergeTwoLists(ans, listHead);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        ListNode mergedList = mergeTwoLists(list1, list2);
        head.next = mergedList;
        return head;
    }


}
