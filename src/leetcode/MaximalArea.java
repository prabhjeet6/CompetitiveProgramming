package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/
public class MaximalArea {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int size=matrix[0].length;
        char [] heights=new char[size];
        for(int i=0;i<size;i++){
            if(matrix[0][i]=='1'){
                heights[i]=1;
            }
        }
        int maxArea=maxAreaHistogram(heights);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<size;j++){
               if(matrix[i][j]=='1'){
                   heights[j]++;
               }else{
                   heights[j]=0;
               }
            }
            maxArea=Math.max(maxArea,maxAreaHistogram(heights));
        }
        return maxArea;
    }

    int maxAreaHistogram(char[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }

        }
        return maxArea;
    }
}
