import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Solution {

    // Complete the circularArrayRotation function below.
    static Integer[] circularArrayRotation(Integer[] a, int k, int[] queries) {
        List<Integer> ls = Arrays.asList(a);
        List<Integer> lst=new ArrayList<Integer>();
        lst.addAll(ls);
        int len = lst.size();
        while (k > 0) {
            k--;
            Integer element = lst.get(len - 1);
            lst.add(0, element);
            lst.remove(lst.size() - 1);
        }
        Integer res[] = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = lst.get(queries[i]);
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        Integer[] a = new Integer[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        Integer[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));

            /*if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }*/
            System.out.println(result[i]);
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
