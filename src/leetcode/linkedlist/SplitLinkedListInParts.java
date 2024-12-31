package leetcode.linkedlist;

import leetcode.ListNode;

class SplitLinkedListParts {

    //Approach1
    public ListNode[] splitListToPartsApprocah1(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        // get total size of linked list
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // minimum size for the k parts
        int splitSize = size / k;

        // Remaining nodes after splitting the k parts evenly.
        // These will be distributed to the first (size % k) nodes
        int numRemainingParts = size % k;

        current = head;
        for (int i = 0; i < k; i++) {
            // create the i-th part-a dummy node succeeding the sublist
            ListNode newPart = new ListNode(0);
            ListNode tail = newPart;

            int currentSize = splitSize;
            //first add larger(by 1) parts
            if (numRemainingParts > 0) {
                numRemainingParts--;
                currentSize++;
            }
            int j = 0;
            //single loop to cover both values of currentSize
            while (j < currentSize) {
                //add current value to sublist, go to sublist' next and increment j to check if sublist equals current size, go to next of original list
                tail.next = new ListNode(current.val);
                tail = tail.next;
                j++;
                current = current.next;
            }
            //once the sublist is ready, add it to ans
            ans[i] = newPart.next;
        }

        return ans;
    }

    //Approach2
    public ListNode[] splitListToPartsApproach2(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        int splitSize = size / k;
        int remain = size % k;
        current = head;
        ListNode prev = current;
        for (int i = 0; i < k; i++) {
            ListNode newPart = current;
            int currentSize = splitSize;
            if (remain > 0) {
                remain--;
                currentSize++;
            }
            int j = 0;
            while (j < currentSize) {
                prev = current;
                current = current.next;
                j++;
            }
            if (prev != null) {
                prev.next = null;
            }
            ans[i] = newPart;
        }
        return ans;
    }
}