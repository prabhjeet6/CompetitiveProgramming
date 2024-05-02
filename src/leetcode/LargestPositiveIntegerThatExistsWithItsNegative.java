package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02**/
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String arg[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxK(arr));
    }

    public int findMaxK(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==0&&max<Math.abs(nums[i])){
                    max=Math.abs(nums[i]);
                }
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
       }
    }
