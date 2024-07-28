package leetcode;
//Refer to Notes
//Bottom Top DP
public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int [] longestIncreasingSubSeq=new int[nums.length];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            longestIncreasingSubSeq[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    longestIncreasingSubSeq[i]=Math.max(longestIncreasingSubSeq[i],1+longestIncreasingSubSeq[j]);
                }
            }
            ans=Math.max(longestIncreasingSubSeq[i],ans);
        }
        return ans;
    }
    public static void main(String[] asd){
        int[] nums={10,9,2,5,3,7,101,18};
       LongestIncreasingSubSequence longestIncreasingSubSequence=new LongestIncreasingSubSequence();
       int ans=longestIncreasingSubSequence.lengthOfLIS(nums);
       System.out.println(ans);
    }

}
