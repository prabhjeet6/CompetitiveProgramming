package leetcode;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
     int[] nums={-1};
     new SquaresOfSortedArray().sortedSquares(nums);
    }

    public int[] sortedSquaresBruteForce(int[] nums) {
        return Arrays.stream(nums).map(x -> x * x).sorted().toArray();
    }

    public int[] sortedSquares(int[] nums) {
        //using two pointers
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pivot = i;
                break;
            }
        }
        if(pivot==-1){
            return Arrays.stream(nums).map(x -> x * x).sorted().toArray();
        }
        int p1 = pivot - 1, p2 = pivot , c = 0;
        int resultant[] = new int[nums.length];
        while (p1 >= 0 && p2 <= nums.length - 1) {
            if (nums[p1] * nums[p1] < nums[p2] * nums[p2]) {
                resultant[c] = nums[p1] * nums[p1];
                p1--;
            } else {
                resultant[c] = nums[p2] * nums[p2];
                p2++;
            }
            c++;
        }
        if (p1 >= 0) {
            while (p1 >= 0) {
                resultant[c] = nums[p1] * nums[p1];
                p1--;
                c++;
            }
        } else {
            while (p2 <= nums.length-1) {
                resultant[c] = nums[p2] * nums[p2];
                p2++;
                c++;
            }
        }
        return resultant;
    }
}
