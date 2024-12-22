package codeforces.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class AlternatingCurrent {
    public static void main(String[] a) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String input = bufferedReader.readLine();
        //getIsUntangable(input);
        getIsUntangable("-++-");//Yes
        getIsUntangable("+-");//No
        getIsUntangable("++");//Yes
        getIsUntangable("-");//No
    }

    static void getIsUntangable(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                while (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
            } else
                stack.push(c);
        }
        if (stack.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
