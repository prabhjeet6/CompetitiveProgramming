package leetcode;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        return  Arrays.stream(nums).map(x->x*x).sorted().toArray();
    }
}
