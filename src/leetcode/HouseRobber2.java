package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber-ii/solutions/4062117/java-beats-100-dp-memoization-tabulation-space-optimization/

//Memoisation |Top-Bottom
//TC O(N) SC O(N)
class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        //from index 0 to n-1 to ignore the last house
        int firstHouse = leavemealone(nums,0,n-1,dp);
        //Now we have to reinitialise the dp array to -1
        Arrays.fill(dp,-1);
        //Now to ignore the first house we will iterate from 1 to n
        int lastHouse = leavemealone(nums,1,n,dp);
        return Math.max(firstHouse,lastHouse);
    }

    public int leavemealone(int[] nums, int idx, int n, int dp[]){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        return dp[idx]=Math.max(nums[idx] + leavemealone(nums,idx+2,n,dp), 0 + leavemealone(nums,idx+1,n,dp));
    }
}
//BottomTop|Tabulation
//TC O(N) SC O(1)
class HouseRobber2BottomTop {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1)
            return nums[0];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int firstHouse[] = new int[n];
        int lastHouse[] = new int[n];
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                firstHouse[i] = nums[i];
            }
            if(i!=n-1){
                lastHouse[i] = nums[i];
            }
        }
        return Math.max(solve(firstHouse,dp),solve(lastHouse,dp));
    }

    public int solve(int[] nums,int dp[]){
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1){
                take+=dp[i-2];
            }
            int nottake = 0 + dp[i-1];
            dp[i] = Math.max(take,nottake);
        }
        return dp[nums.length-1];
    }
}