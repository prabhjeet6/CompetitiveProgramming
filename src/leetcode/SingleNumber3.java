package leetcode;


import java.util.HashMap;
import java.util.Map;

class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int res[]=new int[2];
        //Sorting Solution with SC O(1)
         //https://leetcode.com/problems/single-number-iii/submissions/1272834210/
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=2){
                res[count]=nums[i];
                count++;
            }
            if(count==2){
                break;
            }
        }
        return res;

    }
}