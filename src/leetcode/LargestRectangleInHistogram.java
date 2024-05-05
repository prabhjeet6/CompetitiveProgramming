package leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * <p> Stacks ref:
 * https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/28900/short-and-clean-o-n-stack-based-java-solution/
 * BruteForce ref:
 * https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/1727776/java-c-explanation-going-from-brute-to-optimal-approach/
 **/
public class LargestRectangleInHistogram {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int heights[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        largestRectangleInHistogramUsingStacks(heights);
    }

    //TC:O(n^2) SC: O(n)
    static void largestRectangleInHistogramBruteForce(int[] heights) {

        int[] leftBoundary = new int[heights.length];
        boolean leftFlag = false, rightFlag = false;
        //imaginary left index before 0
        leftBoundary[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int prev = i - 1; // previous for comparing the heights
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = leftBoundary[prev]; // we have done this to minimise the jumps we make to the left
            }
            leftBoundary[i] = prev;
            /*for(int j=i-1;j>=0;j--){
                if(heights[j]<heights[i]){
                    leftBoundary[i]=j;
                    leftFlag=true;
                    break;
                }
            }
            if(!leftFlag) {
                leftBoundary[i] = -1;
            }*/
        }
        int[] rightBoundary = new int[heights.length];
        //imaginary right index after heights.length-1
        rightBoundary[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int prev = i + 1;
            while (prev < heights.length && heights[prev] >= heights[i]) {
                prev = rightBoundary[prev];
            }
            rightBoundary[i] = prev;
        }
            /*for(int j=i+1;j>=heights.length-1;j--){
                if(heights[j]<heights[i]){
                    rightBoundary[i]=j;
                    rightFlag=true;
                    break;
                }
            }
            if(!rightFlag) {
                rightBoundary[i] = heights.length;
            }*/
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rightBoundary[i] - leftBoundary[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        System.out.print(maxArea);
    }

    public static void largestRectangleInHistogramUsingStacks(int[] heights) {
        int maxArea = 0;
        //2 1 5 6 2 3
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        System.out.print(maxArea);
    }
}


