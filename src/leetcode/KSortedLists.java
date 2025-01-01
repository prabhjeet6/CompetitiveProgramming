package leetcode;

//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class KSortedLists {

    /*TC:O(N * K^2)
     *
     * Time complexity of merging first two list : 2N
     * Merging third list with the resultant list above : 2N+N
     * Merging fourth list with the resultant list above : 3N+N
     * .....
     * Merging K lists K(2+3+4+5..N)~=O(KN^2)*/
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode listHead : lists) {
            ans = mergeTwoLists(ans, listHead);
        }
        return ans;
    }

    //TC:O(KNlogK)
    public ListNode mergeKListsDivideAndConqur(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeK(lists, 0, lists.length - 1);
    }

    private ListNode mergeK(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        int m = (i + j) / 2;
        ListNode h1 = mergeK(lists, i, m);
        ListNode h2 = mergeK(lists, m + 1, j);
        return mergeTwoLists(h1, h2);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode mergedList = mergeTwoLists(list1, list2);
        head.next = mergedList;
        return head;
    }


}
