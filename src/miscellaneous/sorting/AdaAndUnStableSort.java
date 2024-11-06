package miscellaneous.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ValueAndIndex {
    int value;
    int index;
}

class ValueAndIndexComparator implements Comparator<ValueAndIndex> {

    @Override
    public int compare(ValueAndIndex o1, ValueAndIndex o2) {
        if (o1.value != o2.value) {
            return Integer.compare(o1.value, o2.value);
        }
        return Integer.compare(o2.index, o1.index);
    }
}


public class AdaAndUnStableSort {
    public static void main(String[] as) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<ValueAndIndex> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ValueAndIndex valueAndIndex = new ValueAndIndex();
                valueAndIndex.value = nums[i];
                valueAndIndex.index = i + 1;
                pairs.add(valueAndIndex);
            }
            Collections.sort(pairs, new ValueAndIndexComparator());
            for (ValueAndIndex valueAndIndex : pairs) {
                System.out.print(valueAndIndex.index + " ");
            }
            System.out.println();
        }
    }
}
