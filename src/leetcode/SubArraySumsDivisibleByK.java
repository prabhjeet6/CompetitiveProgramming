package leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubArraySumsDivisibleByK {
    public static void main(String []a){
        System.out.println(-5%3);
    }
    //TC:O(N^2) SC:O(1)
    public int subarraysDivByKBruteForce(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum%k==0){
                    count++;
                }
            }
        }
        return count;
    }
    //TC:O(N) SC: O(K)
    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod=0,result=0;
        //the output of mod will vary from 0 to k-1 for any number, hence,array of size k
        int[] modGroups=new int[k];
        //this is to ensure if mod on the whole array is divisible by k, it gets counted
        modGroups[0]=1;
        for(int i=0;i<nums.length;i++){
            //adds mod of nums[i] at each index to find
            // k is added additionally and another is mod is
            // taken to cater to negative numbers in the array
            prefixMod = (prefixMod + nums[i] % k + k) % k;
            result+=modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return result;
    }

    //Same solution as above method, for better understanding

    //Start with an initial prefix sum of 0.
    //As you go through each number in the array, update the prefix sum by adding the current number.
    //Calculate the remainder of this prefix sum when divided by ( k ).
    //Use the hash map to check if this remainder has been seen before:
    //If it has, it means there are sub arrays that sum to a multiple of ( k ), and you increase your
    // count by how many times this remainder has been seen.
    //Update the hash map to include this new remainder.
        public int subarraysDivByK2(int[] nums, int k) {
            // Initialize count of subarrays, prefix sum, and hash map for remainders
            int count = 0;
            int prefixSum = 0;
            HashMap<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, 1); // To handle subarrays that start from the beginning

            for (int num : nums) {
                // Update prefix sum
                prefixSum += num;

                // Calculate the remainder of the prefix sum divided by k
                int mod = prefixSum % k;

                // Adjust negative remainders to be positive
                if (mod < 0) {
                    mod += k;
                }

                // If this remainder has been seen before, it means there are subarrays ending here that are divisible by k
                if (prefixMap.containsKey(mod)) {
                    count += prefixMap.get(mod);
                    prefixMap.put(mod, prefixMap.get(mod) + 1);
                } else {
                    prefixMap.put(mod, 1);
                }
            }

            return count; // Total number of subarrays divisible by k
        }

}
