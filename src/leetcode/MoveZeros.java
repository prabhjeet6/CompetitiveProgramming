package leetcode;


class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int count = 0;//count the number of non zeros  before current iteration
        while (i < nums.length) {
            if (nums[i] != 0) {
                if (i != count) {
                    swap(nums, i, count);
                }
                count++;
            }
            i++;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
