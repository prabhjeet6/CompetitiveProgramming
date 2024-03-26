package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**https://leetcode.com/problems/3sum/**/
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j !=
// k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
public class ThreeSum {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nums[] = Arrays.stream(bufferedReader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        // Using Two Pointers Technique
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // skip, if first element of triplet repeats
                continue;
            }
            else {
                // if a+b+c=0, then a=-(b+c), hence rem=-1*nums[i];
                int rem = -1 * nums[i];
                int p1 = i + 1, p2 = nums.length - 1;
                while (p1 < p2) {
                    if (nums[p1] + nums[p2] < rem) {
                        p1++;
                    }
                    else if (nums[p1] + nums[p2] > rem) {
                        p2--;
                    }
                    else{
                        List<Integer> triplets=new ArrayList<>();
                        triplets.add(nums[i]);
                        triplets.add(nums[p1]);
                        triplets.add(nums[p2]);
                        result.add(triplets);
                        //triplets=null;
                        if(nums[p1]==nums[p2]){
                            //Array is sorted, hence, if nums[p1]==nums[p2], all elements in between are duplicates.
                            break;
                        }
                        int x=nums[p1],y=nums[p2];
                        while(nums[p1]==x){
                            p1++;
                        }
                        while(nums[p2]==y){
                            p2--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
