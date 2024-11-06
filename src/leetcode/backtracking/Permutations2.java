package leetcode.backtracking;


import java.util.ArrayList;
import java.util.List;

class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(nums, 0, res);
        return res;

    }

    void backtrack(int nums[], int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < nums.length; k++) {
                list.add(nums[k]);
            }
            res.add(list);
            return;
        }
        int frequency[] = new int[21];
        for (int idx = 0; idx < 21; idx++) {
            frequency[idx] = 0;
        }
        for (int j = i; j < nums.length; j++) {
            if (frequency[nums[j] + 10] == 0) {
                swap(nums, i, j);
                backtrack(nums, i + 1, res);
                swap(nums, i, j);
            }
            frequency[nums[j] + 10]++;
        }

    }

    void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}