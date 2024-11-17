package leetcode.twopointers;


import java.util.Arrays;

class RemoveElementInPlace {
    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;

    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int l = 0, r = n - 1, count = 0;
        while (l <= r) {
            if (nums[l] == val && nums[r] != val) {
                swap(nums, l, r);
                l++;
                r--;
                count++;
            } else {
                if (nums[l] != val) {
                    l++;
                }
                if (nums[r] == val) {
                    r--;
                    count++;
                }
            }
        }
        System.out.print(Arrays.toString(nums));
        return n - count;
    }
}