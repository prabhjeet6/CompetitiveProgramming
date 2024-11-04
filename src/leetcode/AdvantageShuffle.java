package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] nums1Sorted = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(nums1Sorted);

        int[] nums2Sorted = Arrays.copyOf(nums2, nums1.length);
        Arrays.sort(nums2Sorted);

        Map<Integer, Integer> nums2SortedToNums1Sorted = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums2SortedToNums1Sorted.put(nums2Sorted[i], nums1Sorted[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums2SortedToNums1Sorted.get(nums2[i]);
        }
        return nums1;
    }
}
