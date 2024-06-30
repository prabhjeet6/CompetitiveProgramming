package leetcode;


class MinimumOperationsToMakeBinaryArrayOne {
    //Hint1:If nums[0] is 0, then the only way to change it to 1 is by doing an operation on the first 3
    // elements of the array.
    //After Changing nums[0] to 1, use the same logic on the remaining array.
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