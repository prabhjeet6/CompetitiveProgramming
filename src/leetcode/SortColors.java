package leetcode;
//https://leetcode.com/problems/sort-colors/

class SortColors {
    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void sortColors(int[] nums) {
        int count = 0;

        int one = 0, zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 2) {
                if (i != count) {
                    swap(nums, i, count);
                }
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < (zero + one); i++) {
            if (nums[i] != 1) {
                if (i != count) {
                    swap(nums, i, count);
                }
                count++;
            }
        }
    }
}
