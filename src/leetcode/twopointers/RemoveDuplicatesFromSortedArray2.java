package leetcode.twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
public class RemoveDuplicatesFromSortedArray2 {
    //Input: nums = [1,1,1,2,2,3]
    //Output: 5, nums = [1,1,2,2,3,_]

    //Input: nums = [0,0,1,1,1,1,2,3,3]
    //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
    public static void main(String[] a){
        int[]nums=new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        //two pointers approach, maintaining i and j
       int i=0,n=nums.length,count=0;
       for(int j=1;j<n;j++){
           if(count<1||nums[i]!=nums[j]){
               // if count==1 you have already taken one duplicate
               if(count==1)count=0;
               //count should only be increased, if it is a duplicate
               if(nums[i]==nums[j]) count++;
               i++;
               nums[i]=nums[j];
           }


       }

       return i+1;
    }
}
