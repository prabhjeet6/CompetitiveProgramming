package leetcode;
//https://leetcode.com/problems/remove-duplicate-letters/description/

import java.util.Stack;

class RemoveDuplicateLetters {
    public static void main(String[] as) {
        //abc
        System.out.println(removeDuplicateLetters("acbac"));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] isPresentInStack = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (stack.isEmpty() || (currentChar > stack.peek() && !isPresentInStack[currentChar - 'a'])) {
                stack.push(currentChar);
                isPresentInStack[currentChar - 'a'] = true;
            } else {
                if (!isPresentInStack[currentChar - 'a']) {
                    while (!stack.isEmpty()&&s.substring(i + 1).contains(stack.peek().toString())&& (currentChar <stack.peek())) {
                        isPresentInStack[stack.peek() - 'a'] = false;
                        stack.pop();
                    }
                    stack.push(currentChar);
                    isPresentInStack[currentChar - 'a'] = true;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            res.append(stack.get(i));
        }
        return res.toString();
    }
}
