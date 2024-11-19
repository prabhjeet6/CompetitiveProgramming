package leetcode.twopointers;


class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i=0;
        //iterate through the array
        //if the elements match, keep moving else, just increase the pointer and assign the value of
        // nums[j] to incremented i index so that unique element is in order, here i tracks unique
        // elements
        // no need to swap as rest of the duplicate elements do not matter
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }

        //1 2 2 3
        //i is 0 indexed
        return i+1;
    }
}