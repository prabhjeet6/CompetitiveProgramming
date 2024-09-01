package leetcode;
//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashMap;
import java.util.Map;
//refer notes in case of doubt
//TC:O(N) SC: O(N)
class LongestConsequtiveSequence {
    static Map<Integer, Integer> streak = new HashMap<>();
    static int ans = 0;

    public static void main(String[] asd){
        int[] nums=new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        for (int num : nums) {
            if (!streak.containsKey(num)) {
                int leftStreak = streak.getOrDefault(num - 1, 0);
                int rightStreak = streak.getOrDefault(num + 1, 0);
                ans = Math.max(ans, leftStreak + rightStreak + 1);
                streak.put(num, leftStreak + rightStreak + 1);
                streak.put(num - leftStreak, leftStreak + rightStreak + 1);
                streak.put(num + rightStreak, leftStreak + rightStreak + 1);

            }
        }
        return ans;
    }
}
