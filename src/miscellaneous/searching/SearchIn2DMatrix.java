package miscellaneous.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchIn2DMatrix {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int t = Integer.parseInt(bufferedReader.readLine());
        //bruteForce(t,m,n,matrix,bufferedReader);
        searchTargetUsingBinarySearch(t,m,n,matrix,bufferedReader);
        /*You can optimize further by treating the entire matrix as a flattened 1D array, which will
         allow you to perform a single binary search across the entire matrix instead of first
         narrowing down to a row.Each row is sorted from left to right.The first element of each
         row is greater than the last element of the previous row.This means you can treat the matrix
          as a 1D sorted array. The index (i, j) in the 2D matrix can be mapped to an index k in the
          flattened 1D array using the formula:

          k = i * n + j
          Conversely, to get back to the 2D matrix indices from k, use:i = k / n
          j = k % n*/
    }

    private static void searchTargetUsingBinarySearch(int t, int m, int n, int[][] matrix, BufferedReader bufferedReader) throws IOException {
       while(t>0){
           t--;
           int target = Integer.parseInt(bufferedReader.readLine());
           int narrowedToRow=-1;
           for(int i=0;i<m;i++) {
               if (matrix[i][n - 1] >= target) {
                   narrowedToRow = i;
                   break;
               }
           }
               if(narrowedToRow==-1){
                   System.out.println("false");
                   continue;
               }
               if(binarySearch(matrix[narrowedToRow],target)){
                   System.out.println("true");
               }else{
                   System.out.println("false");
               }

       }
    }
    private static boolean binarySearch(int[] a, int target){
        int low=0,high=a.length-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(a[mid]==target){
                return true;
            }
            if(a[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }

    void bruteForce(int t,int m,int n,int[][]matrix,BufferedReader bufferedReader) throws IOException {
        while (t > 0) {
            t--;
            int target = Integer.parseInt(bufferedReader.readLine());
            int narrowedToRow=-1;
            for(int i=0;i<m;i++){
                if(matrix[i][n-1]>=target){
                    narrowedToRow=i;
                    break;
                }
            }
            if(narrowedToRow==-1){
                System.out.println("false");
                continue;
            }
            boolean found=false;
            for(int i=0;i<n;i++){
                if(matrix[narrowedToRow][i]==target){
                    found=true;
                    break;
                }
            }
            if(found){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}
