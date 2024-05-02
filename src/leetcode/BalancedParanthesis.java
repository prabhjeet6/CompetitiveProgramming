package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BalancedParanthesis {
    public static void main(String args[]) {
        new BalancedParanthesis().isValid("]");
    }

    public boolean isValid(String s) {
        List<String> openBrackets = new ArrayList<String>();
        openBrackets.add("(");
        openBrackets.add("{");
        openBrackets.add("[");
        List<String> closedBrackets = new ArrayList<String>();
        closedBrackets.add(")");
        closedBrackets.add("}");
        closedBrackets.add("]");
        int i = 0;
        Stack<String> stack = new Stack<String>();
        //Hint: iterate through input and not through stack
        /** Iterate through String, if it is open bracket, push, else if it is closed bracket, and stack is
         * empty return false,or, if the bracket does not match stack top, return false, otherwise pop stack top,
         * return stack.isEmpty() after iterating through the String, just in case there are elements left in the stack
         * */
        while (i < s.length()) {
            if (openBrackets.contains(String.valueOf(s.charAt(i)))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (closedBrackets.contains(String.valueOf(s.charAt(i)))) {
                if (!stack.isEmpty()) {
                    if ("(".equals(stack.peek()) && ")".equals(String.valueOf(s.charAt(i)))
                            || "{".equals(stack.peek()) && "}".equals(String.valueOf(s.charAt(i)))
                            || "[".equals(stack.peek()) && "]".equals(String.valueOf(s.charAt(i)))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}





