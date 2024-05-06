package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
 *
 * Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.
 * */
public class GenerateBinaryNumbers {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());
        System.out.println(generate(N));

    }
    static ArrayList<String> generate(int N) {
        List<String> resultant=new ArrayList<>();
        Queue<String> levelOrderTraversalQueue=new ConcurrentLinkedQueue<>();

        levelOrderTraversalQueue.add(String.valueOf(1));
        for(int i=2;i<=N+1;i++){
            String binaryValue=levelOrderTraversalQueue.peek();
            resultant.add(binaryValue);
            levelOrderTraversalQueue.poll();
            levelOrderTraversalQueue.add(binaryValue+'0');
            levelOrderTraversalQueue.add(binaryValue+'1');
        }
        return (ArrayList<String>) resultant;
    }

}
