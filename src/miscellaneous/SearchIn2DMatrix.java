package miscellaneous;

import java.io.BufferedReader;
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
