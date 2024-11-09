package leetcode.sorting;


import java.util.Arrays;
//https://leetcode.com/problems/largest-perimeter-triangle/description/
class LargestPerimeterTriangle {
    //use the triangle inequality theorem, which states that the sum of any two sides of a triangle
    // must be greater than the length of the third side
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-3;i>=0;i--){
            //the reason it needs not to check for other indices, but only last three, is because of
            //triangle inequality theorem stated above
            if(nums[i]+nums[i+1]>nums[i+2])
                return nums[i]+nums[i+1]+nums[i+2];
        }
        return 0;

    }
}