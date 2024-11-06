package leetcode.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {

    public static void main(String as[]){
        int[] nums={1000000000,1000000000,1000000000,1000000000};

        System.out.println(fourSum(nums,-294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            //All 4 numbers should be unique, this check is for uniqueness of first two numbers
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                //All 4 numbers should be unique, this check is for uniqueness of first two numbers
                if(j-1!=i&&nums[j]==nums[j-1]){
                    continue;
                }
                //two pointers approach for 3rd and 4th integers
                long rem=target-((long)(nums[i]+nums[j]));
                int left=j+1,right=nums.length-1;
                while(left<right){
                    if((long)(nums[left]+nums[right])==rem){
                        List<Integer> temp=new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);

                        ans.add(temp);

                        if(nums[left]==nums[right]){
                            //other distinct elements not available between
                            // these two in sorted Array
                            break;
                        }
                        int x=nums[left],y=nums[right];
                        while(x==nums[left]){
                            left++;
                        }
                        while(y==nums[right]){
                            right--;
                        }
                    }else if((long)(nums[left]+nums[right])<rem){
                        left++;
                    }else{
                        right--;
                    }
                }

            }
        }
        return ans;
    }
}