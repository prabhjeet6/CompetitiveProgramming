package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MissingNumber {
    public static void main(String args[]){
        int nums[]={9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberUsingHashSet(nums));
    }
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int flag=0,ans=-1;
        Arrays.sort(nums);
        for(int i=0;i<=n;i++){
            if(!binarySearch(nums,i)){
                return i;
            }

        }
        return -1;
    }

        public int missingNumberBruteForce(int[] nums) {
            int n=nums.length;
            int flag=0,ans=-1;

            for(int i=0;i<=n;i++){
                flag=0;
                for(int j=0;j<n;j++){
                    if(i==nums[j]){
                        flag=1;
                        break;
                    }

                }
                if(flag==0){
                    ans =i;
                }
            }
            return ans;
        }
    //SC O(N) TC O(N)
    public static int missingNumberUsingHashSet(int[] nums) {
        Set<Integer>set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans=-1;
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                ans= i;
                break;
            }
        }
        return ans;
    }

    public static int missingNumberO1Space(int[] nums) {
        int n=nums.length;
        int s=(n*(n+1))/2;

        for(int i=0;i<nums.length;i++){
          s-=nums[i];
        }
        return s;

    }

    boolean binarySearch(int []nums,int i ){

        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==i){
                return true;
            }
            else if(nums[mid]<i){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return false;
    }


}
