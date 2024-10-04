package leetcode;


import java.util.HashMap;
import java.util.Map;

class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> aPlusB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aPlusB.put(nums1[i] + nums2[j], aPlusB.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int keyToBeSeached = -1 * (nums3[i] + nums4[j]);
                if (aPlusB.containsKey(keyToBeSeached)) {
                    count+=aPlusB.get(keyToBeSeached);
                }
            }
        }
        return count;
    }
}