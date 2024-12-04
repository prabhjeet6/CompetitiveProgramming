package leetcode.twopointers;
//https://leetcode.com/problems/max-consecutive-ones-iii/

class MaxConsequtiveOnes3 {
    public static void main(String[] a) {
        System.out.println(longestOnesBruteForce(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    //TC:O(N^2) SC:O(1)
    public static int longestOnesBruteForce(int[] nums, int k) {
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                if (zeros <= k) {
                    int l = j - i + 1;
                    maxOnes = Math.max(maxOnes, l);
                }
            }
        }
        return maxOnes;
    }


}

