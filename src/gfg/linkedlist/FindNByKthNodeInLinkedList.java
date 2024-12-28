package gfg.linkedlist;


class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class FindNByKthNodeInLinkedList {
    public static int fractional_node(Node head, int k) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int element = 0;
        if (count % k == 0) {
            element = (count / k);
        } else {
            int fraction = 0;
            if (count % k >= 0.5) fraction = 1;
            element = count / k + fraction;
        }
        temp = head;
        count = 0;
        int val = 0;
        while (temp != null) {
            count++;
            if (count == element) {
                val = temp.data;
            }
            temp = temp.next;
        }
        return val;
    }
}