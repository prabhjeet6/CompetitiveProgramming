package gfg;


class LongestBitonicSequence {
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] lis=getLIS(nums);
        int[] lds=getLDS(nums);
        int ans=0;
        for(int i=0;i<n;i++){
            if(lds[i]!=1&&lis[i]!=1) {
                ans = Math.max(lds[i] + lis[i]-1, ans);
            }
        }
        return ans;
    }

    public static int[] getLIS(int[] nums) {
        int[] longestIncreasingSubSeq = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longestIncreasingSubSeq[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    longestIncreasingSubSeq[i] = Math.max(longestIncreasingSubSeq[i], 1 + longestIncreasingSubSeq[j]);
                }
            }
        }
        return longestIncreasingSubSeq;
    }

    public static int[] getLDS(int[] nums) {
        int[] longestDecreasingSubSeq = new int[nums.length];
        for (int i =  nums.length-1;i>=0; i--) {
            longestDecreasingSubSeq[i] = 1;
            for (int j = i+1; j<nums.length  ; j++) {
                if (nums[i] > nums[j]) {
                    longestDecreasingSubSeq[i] = Math.max(longestDecreasingSubSeq[i], 1 + longestDecreasingSubSeq[j]);
                }
            }
        }
        return longestDecreasingSubSeq;
    }
}
