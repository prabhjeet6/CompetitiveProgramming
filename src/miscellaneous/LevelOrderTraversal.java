package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Given a positive number N, print first 'N' natural numbers whose digits belonging to {1,2,3}.
 * Print in sorted form
 */
public class LevelOrderTraversal {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader((System.in)));
        int N=Integer.parseInt(bufferedReader.readLine());
        int c=0;
        Queue<Integer> queue=new ConcurrentLinkedQueue<>();
        queue.add(0);
        while(c<N){
            Integer x=queue.peek();
            if(x!=0){
                System.out.println(x);
                c++;
            }
            queue.poll();
            queue.add(x*10+1);
            queue.add(x*10+2);
            queue.add(x*10+3);


        }

    }

}
