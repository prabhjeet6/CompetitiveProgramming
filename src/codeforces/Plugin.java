package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

//https://codeforces.com/contest/81/problem/A?mobile=true
public class Plugin {
    public static void main(String[] as) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        pluginOutput(s);

    }

    static void pluginOutput(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
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


        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        System.out.println(ans);
    }
}

