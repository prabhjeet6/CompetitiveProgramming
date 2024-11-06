package miscellaneous;

import java.util.Iterator;
import java.util.PriorityQueue;

public class DummyTest {
    public static void main(String[] a) {
        //System.out.println(Arrays.toString(sortTest(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
        sortTest(new int[]{2, 0, 4, 1, 2});
        sortTest(new int[]{1, 3, 0, 0, 2});
    }

    static void sortTest(int[] a) {
        PriorityQueue<TestPair> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            TestPair testPair = new TestPair();
            testPair.val = a[i];
            testPair.idx = i;
            priorityQueue.add(testPair);
        }
        Iterator<TestPair> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().val);
        }
        System.out.println();

    }

}

class TestPair implements Comparable<TestPair> {
    int val;
    int idx;

    @Override
    public int compareTo(TestPair o) {
        return o.val - this.val;
    }
}

