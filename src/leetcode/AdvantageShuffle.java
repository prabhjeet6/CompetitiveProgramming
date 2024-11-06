package leetcode;

import java.util.*;

//https://leetcode.com/problems/advantage-shuffle/editorial/
class AdvantageShuffle {

    public static void main(String[] a) {
        //Use this example only for clarity
        //System.out.println(Arrays.toString(advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
        System.out.println(Arrays.toString(new Solution2().advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        //If the smallest card a in A beats the smallest card b in B, we should pair them. Otherwise,
        // a is useless for our score, as it can't beat any cards.
        //Why should we pair a and b if a > b? Because every card in A is larger than b, any card we
        // place in front of b will score a point. We might as well use the weakest card to pair with
        // b as it makes the rest of the cards in A strictly larger, and thus have more potential to
        // score points.
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int b : B) assigned.put(b, new LinkedList<>());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList<>();


        int j = 0;
        for (int a : sortedA) {
            //In case sortedA is greater than sortedB, it is added in the map, but, please note in case sortedA<sortedB, it is added to remainingList,
            // but, sorted B's index is not increased as it has to still find values in A that are larger than B
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            //In case there are multiple values in map, that means there are duplicates in B multiple a[i] are greater, and hence,
            // we are able to assign to ans[]
            if (!assigned.get(B[i]).isEmpty())
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
}

class Solution2 {
    //GOAL + Approch:
    //we have to maximize Advantage . i.e rearrange array A such that number of idx following
    // this property A[i]>B[i] is maximum.
    //we will approch greedly try the maximum value of A on maximum value of B. if maximum of A is
    // greater than maximum of B. will put that maximum at that index.
    //if maximum value of A is less than maximum value of B .If we put the maximum of A here it is
    // a loss. because its not contributing to advantage so better to put minimum value of A here
    // and use the maximum next time maybe its greater than that and contribute to advantage.
    public int[] advantageCount(int[] A, int[] B) {
        int[] result = new int[A.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < B.length; i++) {
            int val = B[i];
            Pair np = new Pair(val, i);
            pq.add(np);
        }

        Arrays.sort(A);

        int end = A.length - 1;
        int start = 0;
        while (start <= end) {
            Pair top = pq.remove();

            int idx = top.idx;
            int val = top.val;

            int max = A[end];
            int min = A[start];

            if (max > val) {
                result[idx] = max;
                end--;
            } else {
                result[idx] = min;
                start++;
            }
        }
        return result;
    }

    public class Pair implements Comparable<Pair> {
        int idx;
        int val;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair other) {
            return other.val - this.val;
        }
    }
}
