package gfg.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
public class IntersectionInYShapedList {
    int intersectPoint(Node head1, Node head2) {
        Node temp = head1;
        Set<Node> set = new HashSet<>();
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }
}
