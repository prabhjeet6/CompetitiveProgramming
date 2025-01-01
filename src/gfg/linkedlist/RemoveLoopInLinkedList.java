package gfg.linkedlist;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1?page=2&category%5B%5D=Linked%2520List&query=page2category%5B%5DLinked%2520List
public class RemoveLoopInLinkedList {
    static Node prev = new Node();

    public static void removeLoop(Node head) {
        isALoop(head, prev);
    }

    static boolean isALoop(Node head, Node prev) {
        Map<Node, Boolean> map = new HashMap<>();
        Node temp = head;
        prev.next = temp;
        while (temp != null) {
            if (map.containsKey(temp)) {
                prev.next = null;
                return true;
            } else {
                map.put(temp, true);
            }
            prev = prev.next;
            temp = temp.next;

        }
        return false;
    }

    public static void removeLoopUsingTwoPointers(Node head) {
        Node prev = new Node();
        prev.next = head;
        Node slow = head, fast = head;
        boolean loopExists = false;
        Node temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
            if (slow == fast) {
                loopExists = true;
                temp = slow;
                break;
            }
        }
        if (loopExists) {

            Node pivot = head;
            while (!slow.equals(pivot)) {
                slow = slow.next;
                prev = prev.next;
                if (slow.equals(temp)) {
                    pivot = pivot.next;
                }
            }
            prev.next = null;
        }
    }

    public static void main(String[] as) {
        Node one = null, three = null, four = null;
        four = new Node(4);
        three = new Node(3, four);
        four.next = three;
        one = new Node(1, three);
        //removeLoop(one);
        removeLoopUsingTwoPointers(one);
    }

}
