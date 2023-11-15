package leetcode;

import java.util.Scanner;

/*** https://leetcode.com/problems/search-a-2d-matrix-ii/ */
public class SearchA2DMatrix {
	 static public boolean searchMatrix(int[][] matrix, int target) {
	        int i=0,j=matrix[0].length-1;
	        while(i<matrix.length&&j>=0){
	            if(matrix[i][j]==target){
	                return true;
	            }else if(matrix[i][j]>target){
	                j--;
	            }else{
	                i++;
	            }
	        }
	        return false;
	    }
public static void main(String args[]) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int m=s.nextInt();
	int matrix[][]=new int [n][m];
	
	for(int i=0;i<n;i++) {
		for(int j=0;j<m;j++) {
			matrix[i][j]=s.nextInt();
			
		}
	}
	int target=s.nextInt();
	System.out.println(searchMatrix(matrix, target));
}
}
