package hackerrank.stack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Pair {
    int maxElement;
    int val;
}

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
    static Stack<Pair> stack = new Stack<>();

    static void push(int val) {
        Pair p = new Pair();
        p.val = val;
        if (stack.isEmpty()) {
            p.maxElement = val;
        } else {
            int currentMax = stack.peek().maxElement;
            if (currentMax < val) {
                p.maxElement = val;
            } else {
                p.maxElement = currentMax;
            }
        }
        stack.push(p);
    }


    public static List<Integer> getMax(List<String> operations) {
        List<Integer> ans = new ArrayList<>();
        for (String op : operations) {
            String[] operation = op.split(" ");
            if ("1".equals((operation[0]))) {
                push(Integer.parseInt(operation[1]));
            } else if ("2".equals((operation[0]))) {
                stack.pop();
            } else {
                ans.add(stack.peek().maxElement);
            }

        }
        return ans;

    }

}

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = Result.getMax(ops);
        System.out.println(res);
       /* bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

