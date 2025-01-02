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


    public static void main(String[] as) {

        /*Node one2 = new Node(8);
        Node six = new Node(6, one2);
        Node five2 = new Node(5, six);


        Node five = new Node(5, null);
        Node four2 = new Node(4, five);
        Node eight = new Node(8, four2);
        Node one = new Node(1, eight);
        Node four = new Node(4, one);

        one2.next = eight;
        System.out.println(intersectPointUsingTwoPointers(four, five2));*/


        Node ten=new Node(10);
        Node thirty = new Node(30, null);
        Node fifteen = new Node(15, thirty);
        ten.next=fifteen;
        Node nine = new Node(9, fifteen);
        Node six = new Node(6, nine);
        Node three = new Node(3, six);

        System.out.println(intersectPointUsingTwoPointers(three, ten));
    }

    static int intersectPointUsingTwoPointers(Node head1, Node head2) {
        Node temp = head1;
        int count1 = 0, count2 = 0;
        while (temp != null) {
            count1++;
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            count2++;
            temp = temp.next;
        }
        Node slow = null, fast = null;
        int diff = Math.abs(count1 - count2);
        if (count1 > count2) {
            slow = head1;
            fast = getNextFast(slow, diff);
            temp = head2;
        } else {
            slow = head2;
            fast = getNextFast(slow, diff);
            temp = head1;
        }

        while (fast != null && getNextFast(fast, diff) != null) {
            slow = slow.next;
            temp = temp.next;
            fast = getNextFast(slow, diff);
            if (slow.equals(temp) || fast.equals(temp)) {
                return fast.data;
            }

        }
        return -1;
    }

    static Node getNextFast(Node slow, int diff) {
        Node fast = slow;
        while (fast != null && diff > 0) {
            diff--;
            fast = fast.next;
        }
        return fast;

    }

}
