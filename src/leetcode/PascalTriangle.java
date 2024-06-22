package leetcode;


import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public static void main(String as[]){
        System.out.print(generate(5));
    }
//[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>previousRow =new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> row =new ArrayList<>();

            for(int j=1;j<=i;j++){
                if(j==1||j==i){
                    row.add(1);
                }
                else{
                    row.add(previousRow.get(j-1-1)+previousRow.get(j-1));
                }
            }
            previousRow.clear();
            previousRow.addAll(row);
            ans.add(row);
        }
        return ans;
    }


}
