package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class PallindromeLinkedList {
    public static void main(String args[]) throws IOException {
        ListNode head = new ListNode(1, null);
        ListNode temp=head;
        int []arr={1,2,3,3,2,1};
        for(int i=0;i<arr.length;i++) {
            ListNode node = new ListNode(arr[i], null);
            temp.next=node;
            temp=node;
        }
        pallindromeLinkedList(head);
    }

    private static boolean  pallindromeLinkedList(ListNode head) {
        if(null==head){
            return true;
        }
        Stack<Integer> stack=new Stack<Integer>();
        ListNode temp=head;
        while(null!=temp){
            stack.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(null!=temp){
             int val=stack.pop();
             if(val!=temp.val){
                 return false;
             }
             temp=temp.next;
        }
        return true;
    }
}
