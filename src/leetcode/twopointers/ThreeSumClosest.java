package leetcode.twopointers;


import java.util.Arrays;

class ThreeSumClosest {
    public static void main(String[] a) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));
        System.out.println(threeSumClosest(new int[]{-4, 2, 2, 3, 3, 3}, 0));
        System.out.println(threeSumClosest(new int[]{2, 5, 6, 7}, 16));
    }


    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int val = 0, ans = 0;
        Arrays.sort(nums);
        int closeVal = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                val = nums[i] + nums[j] + nums[k];
                if (val == target) {
                    return val;
                }
                int currentDiff = Math.abs(target - val);
                //consider equal to situation, and do not only check for less or more,
                // otherwise loop may run indefinitely
                //compared val with target instead of comparing on closeVal
                if (val < target) {
                    j++;
                } else {
                    k--;
                }
                if (closeVal > currentDiff) {
                    closeVal = currentDiff;
                    //return ans instead of val, there could be a situation where val is calculated,but
                    //then loop terminates, in that case, answer corresponds to the previous value that
                    //satisfied and not newly calculated val
                    ans = val;
                }
            }
        }
        return ans;
    }

    public static int threeSumClosest1(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int val = 0, ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                val = nums[i] + nums[j] + nums[k];
                if (val == target) {
                    return val;
                }
                int closeVal = Math.abs(target - val);
                //consider equal to situation, and do not only check for less or more,
               // otherwise loop may run indefinitely
                if (closeVal > min) {
                } else {
                    min = closeVal;
                    //return ans instead of val, there could be a situation where val is calculated,but
                   //then loop terminates, in that case, answer corresponds to the previous value that
                  //satisfied and not newly calculated val

                    ans = val;
                }
                if(val>target) k--;
                else j++;
            }
        }
        return ans;
    }

}

