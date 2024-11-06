package leetcode.recursion;
/***https://leetcode.com/problems/combinations/*/
import java.util.ArrayList;
import java.util.List;

class Combinations {

    List<Integer> temp;
    List<List<Integer>> res;

    public static void main(String as[]){
        System.out.println(new Combinations().combine(4,2));
    }

    void findCombinations(int n,int k,int i){
        if(temp.size()==k){
            List<Integer> subList = new ArrayList<>(temp);
            res.add(subList);
            return;
        }
        for(int j=i;j<=n;j++){
            temp.add(j);
            findCombinations(n,k,j+1);
            temp.remove(temp.size()-1);
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        temp=new ArrayList<>();
        res=new ArrayList<>();
         findCombinations(n,k,1);
         return res;

    }

}