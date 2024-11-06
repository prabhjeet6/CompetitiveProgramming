package leetcode.recursion;

//https://leetcode.com/problems/combination-sum-iii/


import java.util.ArrayList;
import java.util.List;
public class SimpleCombinationSum {
    static List<List<Integer>> ans=new ArrayList<>();
    static List<Integer> tempList=new ArrayList<>();
    public static void main(String asf[]){
        System.out.println(combinationSum3(3,7));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        findCombinationSum( k, n, 0,n, tempList,1 );
        return ans;
    }
    static void findCombinationSum(int k,int n, int i,int sum,List<Integer> tempList,int p ){
        if(i==k ){
            if(sum==0){
                List<Integer>sumList=new ArrayList<>(tempList);
                ans.add(sumList);
            }
            return;
        }
        if(sum<0){
            return;
        }
        for(int j=p;j<=n;j++) {
            tempList.add(j);
            findCombinationSum(k, n, i + 1, sum -j, tempList,j+1);
            tempList.remove(tempList.size()-1);
        }
    }

}

