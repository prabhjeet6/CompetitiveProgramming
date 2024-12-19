package leetcode.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class CheckIfAWordIsValidAfterSubstitution {
    public static void main(String[] a) {
        System.out.println(isValid("abbcc"));
    }

    public boolean isValidBruteForce(String s) {
        while (true) {
            int index = s.indexOf("abc");
            if (index != -1) {
                s = s.replaceFirst("abc", "");
            } else {
                return s.isEmpty();
            }
        }
    }

    // s = "aabcbc"
    public static boolean isValid(String s) {
        if (s.length() < 3 || s.charAt(0) == 'b' || s.charAt(0) == 'c') return false;
        Deque<Character> stack = new LinkedList<>();
        char[] input = s.toCharArray();
        for (char c : input) {
            if (c == 'c') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}
