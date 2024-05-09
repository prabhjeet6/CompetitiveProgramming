package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
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
        System.out.println(hasCycle(head));

    }
    //SC:O(1) Using Two Pointers
    public  static boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;

        while(null!=fast&&null!=fast.next){
            fast=fast.next.next;
            slow=slow.next;
            if(null!=fast&&fast.equals(slow)){
                return true;
            }
        }
        return false;

    }

    static public boolean hasCycleUsingHashMap(ListNode head) {
        Map<ListNode, Boolean> isNodeVisited = new HashMap<>();
        ListNode temp=head;
        while (null!=temp){
            if(!isNodeVisited.containsKey(temp)){
                isNodeVisited.put(temp,true);
            }else{
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
}
