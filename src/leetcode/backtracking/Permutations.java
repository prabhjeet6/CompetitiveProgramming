package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] as){
        int nums[]={1,2,3};
        System.out.println(new Permutations().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack( nums, 0,  ans);
        return ans;
    }

    private void backtrack(int[] nums, int i, List<List<Integer>> ans) {
        if(i==nums.length){
            List<Integer> subList=new ArrayList<>();
            for(int val:nums){
                subList.add(val);
            }
            ans.add(subList);
            return;
        }
        for(int j=i;j<nums.length;j++ ){
            //Input: nums = [1,2,3]
            //Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
            swap(nums,i,j);
            backtrack(nums,i+1,ans);
            swap(nums,i,j);
        }
    }

    //







    void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
