package gfg.linkedlist;


import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/find-length-of-loop/1?track=Placement
class LengthOfCycleInLinkedList {
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

    public int countNodesInLoopUsingTwoPointers(Node head) {
        Node slow=head,fast=head;
        boolean loopExists=false;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                loopExists=true;
                break;
            }
        }
        if(!loopExists){
            return 0;
        }else{
            Node temp=slow;
            int count=1;
            slow=slow.next;
            while (slow!=temp){
                slow=slow.next;
                count++;
            }
            return count;
        }
    }
}