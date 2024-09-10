package leetcode;

//https://www.youtube.com/watch?v=lIar1skcQYI
public class ReverseNodesInKGroups {
    public static void main(String[] as) {
        //[1,2,3,4,5], k = 2
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        System.out.println(reverseKGroup(one, 3));

    }

    private static ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while (k > 0 && temp != null) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Key Idea is to break the LinkedList into Individual LinkedLists of size K each, reverse them
     * one by one and link them back.
     * TC:O(N)
     * SC:O(1)
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        //traverse through the List
        while (temp != null) {
            //finds Kth Node if it exists, else returns null
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                //if kth Node does not exist, that means remaining part of the list has less than k nodes
                //link it to the next of prevLast
                //It is possible that prevLast is null, in case the original LinkedList itself has less than
                // K nodes,hence, a null check
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                //break, because, there is no more k length segment, and we have the desired List with us.
                break;
            }
            //preserve next of kth Node
            ListNode nextNode = kthNode.next;
            //make next of kthNode point to null to make K segment an individual LinkedList
            kthNode.next = null;
            //reverse the individual k length list
            reverseSubList(temp);

            if (temp == head) {
                //if it is the first k length segment, make head point to kthNode, which is first node
                // of  first reversed k length individual LinkedList
                head = kthNode;
            } else {
                //Else, make prevLast's next  point to kthNode, which is first node
                // of  first reversed k length individual LinkedList to link to already
                // reversed part of original LinkedList
                prevLast.next = kthNode;
            }
            //After the reversal of segment, prevLast points to temp
            // (node on the right side after reversal of k length segment )
            prevLast = temp;
            //temp points to nextNode which preserves rest of the List, which got detached after
            // individual Linked List was created.
            temp = nextNode;
        }
        return head;
    }

    public static ListNode reverseSubList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (null != current) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head = prev;
        return head;
    }
}
