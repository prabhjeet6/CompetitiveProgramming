package miscellaneous;


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class MaximizeIndexDifference {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int a[] = new int[n];
        String input[] = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        //bruteForce(n,a);
        //Initialized max to 0 to cover case where array size is 1
        int max = 0;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair p = new Pair();
            p.val = a[i];
            p.oldIndex = i;
            list.add(p);
        }
        Collections.sort(list);
        //1 2 3 8 10 30 33 34 80   val
        //8 4 3 1 2  6   7  0 5    oldIndex
        //8 7 7 7 7  7   5  5 5    suffixMax
        int suffixMax = list.get(n - 1).oldIndex;
        for (int i = list.size() - 2; i >= 0; i--) {


            if (max < (suffixMax - list.get(i).oldIndex)) {
                max = suffixMax - list.get(i).oldIndex;
            }
            if (suffixMax < list.get(i).oldIndex) {
                suffixMax = list.get(i).oldIndex;
            }
        }
        System.out.print(max);

    }
}

class Pair implements Comparable<Pair> {
    int val;
    int oldIndex;

    public int compareTo(Pair p) {
        if (this.val < p.val) {
            return -1;
        } else if (this.val > p.val) {
            return 1;
        } else {
            //maintain stabilty of sort
            return Integer.compare(this.oldIndex, p.oldIndex);
        }
    }
}
