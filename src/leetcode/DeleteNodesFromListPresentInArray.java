package leetcode;

import java.util.HashSet;
import java.util.Set;

class DeleteNodesFromListPresentInArray {
    public static void main(String asd[]) {
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        int[] nums = {1, 2, 3};
        System.out.println(modifiedList(nums, one));
    }

    static public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        ListNode temp = head;
        while (null != temp && null != temp.next) {
            if (numSet.contains(head.val)) {
                temp = temp.next;
                head=temp;
            } else if (numSet.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
