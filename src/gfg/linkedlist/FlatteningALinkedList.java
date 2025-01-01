package gfg.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class FlatteningALinkedList {
    class Node {
        int data;
        Node next;
        Node bottom;
    }

    Node flatten(Node root) {
        List<Node> list = new ArrayList<>();
        Node temp = root;
        while (temp != null) {
            Node aux = temp;
            list.add(aux);
            temp = temp.next;
            aux.next = null;
        }

        Node ans = null;
        for (Node node : list) {

            ans = merge(node, ans);
        }
        return ans;
    }

    Node merge(Node head1, Node head2) {
        Node head = null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.data < head2.data) {
            head = head1;
            head1 = head1.bottom;
        } else {
            head = head2;
            head2 = head2.bottom;
        }
        head.bottom = merge(head1, head2);
        return head;
    }
}
