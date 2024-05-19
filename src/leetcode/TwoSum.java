package leetcode;

import java.util.*;
class TwoSum {
    public static void main(String as[]){
        System.out.println(Arrays.toString(twoSumHashMap(new int[]{3,3},6)));
    }
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]==target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static int[] twoSumTwoPointers(int[] nums, int target) {

        int l=0,r=nums.length-1;
        int result[]=new int [2];
        int numsCopy[]=new int[nums.length];
        numsCopy=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        //Map<Integer,Integer>indicesMap=new HashMap<>();
        int lNums=0,rNums=0;

        while(l<r){
            if(nums[l]+nums[r]==target){
                //result[0]=indicesMap.get(nums[l]);
                //result[1]=indicesMap.get(nums[r]);
                lNums=nums[l];
                rNums=nums[r];
                break;
            }
            else if(nums[l]+nums[r]<target){
                l++;
            }else{
                r--;
            }
        }
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(numsCopy[i]==lNums){
                result[counter]=i;
                counter++;
            }else if(numsCopy[i]==rNums){
                result[counter]=i;
                counter++;
            }

        }
        return result;
    }
}
