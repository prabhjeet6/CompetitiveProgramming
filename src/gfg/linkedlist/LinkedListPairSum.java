package gfg.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListPairSum {
    public static void main(String[] a) {
        Node five = new Node(5, null);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);
        calculate(one, 2);

    }

    static void calculate(Node head, int k) {
        Node temp = head;
        Set<Integer> set = new HashSet<>();
        boolean found = false;
        while (temp != null) {
            if (set.contains(k - temp.data)) {
                found = true;
                System.out.println("Pair Sum is ( " + (k - temp.data) + "," + temp.data + ")");
                break;
            }
            set.add(temp.data);
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No pair exist ");
        }

    }


}
