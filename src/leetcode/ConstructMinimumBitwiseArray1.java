package leetcode;
//https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/description/

import java.util.List;

class ConstructMinimumBitwiseArray1 {
    public int[] minBitwiseArray(List<Integer> nums) {
        //3 011 001 010 011
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            boolean found = false;
            for (int j = 1; j < nums.get(i); j++) {
                if ((j | (j + 1)) == nums.get(i)) {
                    found = true;
                    ans[i] = j;
                    break;
                }
            }
            if (!found) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
