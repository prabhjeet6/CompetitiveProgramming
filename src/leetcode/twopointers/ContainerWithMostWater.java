package leetcode.twopointers;


//https://www.youtube.com/watch?v=Uj3gJjg6SXc
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int maxWater = Integer.MIN_VALUE;
        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            maxWater = Math.max(maxWater, (r - l) * minHeight);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxWater;
    }
}