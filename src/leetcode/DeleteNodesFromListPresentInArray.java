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
            //Using set gives O(1) search and total TC of O(n) compared with O(n^2) if we use a parent loop for nums array
            if (numSet.contains(head.val)) {
                temp = temp.next;
                //if head is to be removed, after temp traverses to next node, mark head as temp, else, it will break head's linkage to temp
                head=temp;
            }
            //Instead of looking for the element to remove, look for the element whose next element has to be removed,that way,
            // additional parent node is not needed, you can access next node(node to be deleted), and next's next node(to be linked with current node)
            else if (numSet.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
