package codeforces.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//https://codeforces.com/contest/81/problem/A?mobile=true
public class Plugin {

    public static void main(String[] as) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        pluginOutput(s);
    }

    static void pluginOutput(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (top != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        //Run in Java 11+, Java 8 is slow, hence, will give TLE
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        System.out.println(str.reverse());
    }
}

