package leetcode.twopointers;


import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/count-number-of-nice-subarrays/editorial/
class CountNumberOfNiceSubArrays {
    public static void main(String[] a) {
        System.out.println(numberOfSubarraysBruteForce(new int[]{1, 1, 2, 1, 1}, 3));
    }
    //TC:O(N) SC:O(N)
    public static int numberOfSubarraysBruteForce(int[] nums, int k) {
        int oddCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 1) {
                    count++;
                }
                if (count == k) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }

    /*Since we only need to find the number of subarrays that contain a certain count of odd
    elements, we can ignore the numerical values of the elements and replace all odd values with
     1 and even values with 0.

    Now, all we need to do is identify sequences of elements within the array whose sum equals the
    number of odd elements needed to make a nice array. Solutions that require sequences of elements
    to meet criteria often utilize prefix sums, also sometimes referred to as cumulative sums.

    Since we only need to find the number of subarrays that contain a certain count of odd elements,
    we can ignore the numerical values of the elements and replace all odd values with 1 and even
    values with 0.

    Now, all we need to do is identify sequences of elements within the array whose sum equals
    the number of odd elements needed to make a nice array. Solutions that require sequences
    of elements to meet criteria often utilize prefix sums, also sometimes referred to as cumulative
     sums.
    */
    public int numberOfSubarraysHashing(int[] nums, int k) {
        int currSum = 0, subArrays = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(currSum, 1);
        for (int num : nums) {
            currSum += num % 2;
            if (prefixSum.containsKey(currSum - k)) {
                subArrays += prefixSum.get(currSum - k);
            }
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        }
        return subArrays;
    }

    //watch editorial animation in case of confusion
    public int numberOfSubarraysSlidingWindow(int[] nums, int k) {
        //initialize both l and r
        int n=nums.length,l=0,r=0,count=0,initialGap=0,ans=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]%2==1){
                count++;
            }
            if(count==k){
                initialGap=0;
                //maintain window until there are k odd numbers
                while(count==k){
                    //maintain count as l moves forward
                    count-=nums[l]%2;
                    //suarray with or without even number on the left having k odd numbers needs to be counted
                    initialGap++;
                    l++;
                }
            }
            //add all those subarrays for which k odd numbers count was maintained
            ans+=initialGap;

        }
        return ans;
    }


}


