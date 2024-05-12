package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 *
 * https://cp-algorithms.com/others/tortoise_and_hare.html
 */
public class FirstNodeOfCycle1 {
    public static void main(String args[]) {

        ListNode head = new ListNode(1, null);
        ListNode temp = head;
        int counter = 2;
        while (counter != 6) {
            ListNode node = new ListNode(counter, null);
            temp.next = node;
            temp = node;
            counter++;
        }
        //System.out.println(head);
        System.out.println(detectCycle(head));

    }

    private static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, temp = null;
        boolean hasCycle = false;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (null != fast && fast.equals(slow)) {
                hasCycle = true;
                temp = slow;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        } else {
            ListNode pivot=head;
            while (!slow.equals(pivot)) {
                slow=slow.next;
                if(slow.equals(temp)){
                    pivot=pivot.next;
                }

            }
            return slow;
        }

    }

    public static ListNode detectCycleUsingHashMap(ListNode head) {

        Map<ListNode, Boolean> isNodeVisited = new HashMap<>();
        ListNode temp = head;
        while (null != temp) {
            if (!isNodeVisited.containsKey(temp)) {
                isNodeVisited.put(temp, true);
            } else {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
