package leetcode.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0, r = 0;
        int m = nums1.length, n = nums2.length;
        List<Integer> ls = new ArrayList<>();
        while (l < m && r < n) {
            if (nums1[l] < nums2[r]) {
                l++;
            } else if (nums1[l] > nums2[r]) {
                r++;
            } else {
                if (!ls.contains(nums1[l])) {
                    ls.add(nums1[l]);
                }
                l++;
                r++;
            }
        }
        int[] res = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}