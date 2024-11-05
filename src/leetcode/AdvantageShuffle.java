package leetcode;

import java.util.*;

//https://leetcode.com/problems/advantage-shuffle/editorial/
class AdvantageShuffle {

    public static void main(String[] a) {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
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

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a : sortedA) {
            //if 'a'  is greater than 'b', then, create list of 'a' that will be greater than
            //'b' and map it against 'b', else, add it to remainingList, as these elements are smallest
            // and hence useless.
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            if (!assigned.get(B[i]).isEmpty())
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
}