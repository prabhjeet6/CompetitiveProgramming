package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***https://leetcode.com/problems/k-diff-pairs-in-an-array/*
 *
 *https://leetcode.com/problems/k-diff-pairs-in-an-array/solutions/1757692/java-easy-to-understand-two-approaches-sorting-hashmap/
 *
 * //https://www.youtube.com/watch?v=a2dCHUM6Mq4
 */

public class UniquePairsWithGivenDifference {

    public static void main(String args[]) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = bufferedReader.readLine().split(" ");
        long N = Long.parseLong(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int arr[] = Arrays.stream(bufferedReader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        //Using Two Pointers Technique
       System.out.println( findPairs(arr, K));
    }

    public int findPairsusingHashMap(int[] nums, int k) {
        //TC:O(n) SC:O(n)
        int pairs = 0, n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> repeatedElements = new HashSet<>();

        for(int ele : nums){
            if(set.contains(ele)) repeatedElements.add(ele);
            set.add(ele);
        }

        // SPECIAL CASE [K == 0]
        if(k == 0) return repeatedElements.size();

        // Traversing the SET not the array.
        for(int elementInSet : set)
            if(set.contains(elementInSet + k)) pairs++;

        return pairs;
    }

        public static int findPairs(int[] nums, int k) {
            //TC:O(nlogn) SC:O(1)
            Arrays.sort(nums);
            int i=0, j=1, diff=0, n=nums.length, sum=Integer.MIN_VALUE;
            int count=0;
            while(j<n && i<n-1){
                // ((nums[i]+nums[j])!=sum) -> this will take care of no repetetion
                //if we found any match, increase i , j by 1
                if(nums[j]-nums[i]==k && (nums[i]+nums[j])!=sum){
                    sum=nums[i]+nums[j];
                    i++; j++; count++;
                }
                //if diff is smaller than k increase j by 1
                else if((nums[j]-nums[i])<k){
                    j++;
                }
                //else case, when diff is greater than k, increase i by 1
                else{
                    i++;
                }
                //check if i and j are not same to aoid duplicates
                if(i==j) j++;
            }
            return count;
        }
    }

