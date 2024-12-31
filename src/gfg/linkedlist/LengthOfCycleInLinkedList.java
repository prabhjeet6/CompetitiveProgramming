package gfg.linkedlist;


import java.util.HashMap;
import java.util.Map;

class LengthOfCycleInLinkedList {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {

        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int idx = 1, counter = 1;
        while (temp != null) {
            if (!map.containsKey(temp)) {
                map.put(temp, idx++);
            } else {
                return (counter - map.get(temp));
            }
            counter++;
            temp = temp.next;
        }
        return 0;
    }

}