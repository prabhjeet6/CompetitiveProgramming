package leetcode.linkedlist;

import leetcode.ListNode;
import org.w3c.dom.ls.LSException;

class ReverseLinkedList2 {
    ListNode before = null, after = null, remain = null;
    void getBefore(ListNode head, int left) {
        if (left == 1) {
            before = null;
            remain = head;
        } else {
            int count = 0;
            ListNode temp = head;
            before = temp;
            while (temp != null) {
                count++;
                if (count == left - 1) {
                    remain = temp.next;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
    }
    void getAfter(int right, int left) {
        int count = left;
        ListNode temp = remain;
        while (temp != null) {
            if (count == right) {
                after = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
            count++;
        }
    }

    public ListNode reverseBetweenApproach1(ListNode head, int left, int right) {
        if (head == null) return null;
        getBefore(head, left);
        getAfter(right, left);
        if (before != null) {
            ListNode temp=before;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = reverseList(remain);
        } else {
            head = reverseList(remain);
        }
        if (remain != null) {
            remain.next = after;
        }
        return head;
    }

    /*Idea:
    * Input: head = [1,2,10,20,30,40,5], left = 3, right = 6
      Output: [1,2,40,30,20,10,5]

      1->2->10->20->30->40->5

      1->2->20->10->30->40->5
      1->2->30->20->10->40->5
      1->2->40->30->20->10->5

      We add dummy node to handle the case of left being at first position. then, we make the not just
      before left as 'prev' node, then we start reversing as illustrated above

     //https://www.youtube.com/watch?v=tHKp8UuOkm4

 */
    public static ListNode reverseBetweenApproach2(ListNode head, int left, int right) {
        if (head == null || left == right) return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to the node before the `left` position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start reversing from the `left` position
        ListNode current = prev.next;
        ListNode next = null;

        // Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            next = current.next;
            // isolates/eliminates next from LinkedList,which is already stored in 'next'
            current.next = next.next;
            //Adds prev's next(where 'next' was already eliminated) after next
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    public static void main(String[]a ){
        ListNode five=new ListNode(5,null);
        ListNode four=new ListNode(4,five);
        ListNode three =new ListNode(3, four);
        ListNode two =new ListNode(2,three);
        ListNode one=new ListNode(1,two);
        reverseBetweenApproach2(one,2,4);
    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextHead = head.next;
        head.next = null;
        ListNode res = reverseList(nextHead);
        nextHead.next = head;
        return res;
    }
}