package leetcode;


import java.util.Arrays;

class SpecialArray {
    public int specialArrayBruteForce(int[] nums) {
        //At most the value of x can be n, as there should x numbers greater than or equal to x
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                }
                if (count > i) {
                    break;
                }
            }
            if (count != i) {
                count = 0;
            } else {
                return count == 0 ? -1 : count;
            }
        }
        return count == 0 ? -1 : count;
    }

    //[0 4 3 0 4]
    //[0 0 3 4 4]
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = n; i > 0; i--) {
            //even the fist element in sorted array is greater
            if (i == n && nums[n - i] >= i) {
                return i;
            }
            //Array is sorted in ascending order only, we are just reading the elements starting from n
            else if (nums[n - i] >= i && nums[n - i - 1] < i) {
                return i;
            }
        }

        return -1;
    }
}

