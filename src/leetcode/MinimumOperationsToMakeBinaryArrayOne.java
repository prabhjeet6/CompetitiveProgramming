package leetcode;


class MinimumOperationsToMakeBinaryArrayOne {
    public int minOperations(int[] nums) {
        int i=0,count=0;
        while(i<nums.length){
            if(nums[i]==0&&i+2<nums.length){
                for(int j=i;j<i+3;j++){
                    nums[j]=1-nums[j];
                }
                count++;
            }
            i++;
        }
        for(int idx=0;idx<nums.length;idx++){
            if(nums[idx]==0){
                return -1;
            }
        }
        return count;
    }


}