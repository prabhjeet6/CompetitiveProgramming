package leetcode.twopointers;

//https://leetcode.com/problems/3sum/

import java.util.*;

class ThreeSum {
    public static void main(String[] a) {
        System.out.println(threeSumBruteForce(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //BruteForce gives TLE
    //Approach: fix one element, and apply two pointers for the rest two, if a+b+c=0
    //then, fixing 'a', b+c should be -a.

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //sort the array to apply two pointers
        Arrays.sort(nums);
        int n = nums.length;

        int q = 1, r = nums.length - 1;
        for (int p = 0; p < n; p++) {
            q = p + 1;
            r = nums.length - 1;
            while (q < r) {

                if ((nums[q] + nums[r]) == (-1 * nums[p])) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[p]);
                    ls.add(nums[q]);
                    ls.add(nums[r]);
                    //once you get list, add it to ans, if it is not already present
                    if (!list.contains(ls)) {
                        list.add(ls);
                    }
                    //change pointers, loop only ends when q becomes greater than r, inorder to find
                    //other combinations
                    q++;
                    r--;
                } else if ((nums[q] + nums[r]) > (-1 * nums[p])) {
                    r--;
                } else {
                    q++;
                }
            }
        }
        return list;
    }

    //Taking Set instead of List prevents TLE
    //TC:O(N^2) SC:O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        //sort the array to apply two pointers
        Arrays.sort(nums);
        int n = nums.length;

        int q = 1, r = nums.length - 1;
        Set<List<Integer>> set = new HashSet<>();
        for (int p = 0; p < n; p++) {
            q = p + 1;
            r = nums.length - 1;
            while (q < r) {

                if ((nums[q] + nums[r]) == (-1 * nums[p])) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[p]);
                    ls.add(nums[q]);
                    ls.add(nums[r]);
                    set.add(ls);


                    //change pointers, loop only ends when q becomes greater than r, inorder to find
                    //other combinations
                    q++;
                    r--;
                } else if ((nums[q] + nums[r]) > (-1 * nums[p])) {
                    r--;
                } else {
                    q++;
                }
            }
        }
        return set.stream().toList();
    }


    public static List<List<Integer>> threeSumWithOutExtraSpace(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //sort the array to apply two pointers
        Arrays.sort(nums);
        int n = nums.length;

        int q = 1, r = nums.length - 1;
        for (int p = 0; p < n; p++) {
            //skip duplicate 'p'
            if (p > 0 && nums[p] == nums[p - 1]) {
                continue;
            }
            q = p + 1;
            r = nums.length - 1;
            while (q < r) {

                if ((nums[q] + nums[r]) == (-1 * nums[p])) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[p]);
                    ls.add(nums[q]);
                    ls.add(nums[r]);
                    list.add(ls);
                    //skip duplicate q and r for those values which constitute ans
                    while (q < r && nums[q] == nums[q + 1]) {
                        q++;
                    }
                    while (q < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    //change pointers, loop only ends when q becomes greater than r, inorder to find
                    //other combinations
                    q++;
                    r--;
                } else if ((nums[q] + nums[r]) > (-1 * nums[p])) {
                    r--;
                } else {
                    q++;
                }
            }
        }
        return list;
    }


}
