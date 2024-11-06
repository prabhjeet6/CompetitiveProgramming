package gfg.recursion;


import java.util.ArrayList;

class SubSetSums {
    ArrayList<Integer> subsetSum=new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        calculateSubSetSums(arr,n,0,0);
        return subsetSum;


    }
    void calculateSubSetSums(ArrayList<Integer> arr, int n,int i,int sum){
        if(i==n){
            this.subsetSum.add(sum);
            return;
        }
        calculateSubSetSums( arr,  n, i+1, sum+arr.get(i));
        calculateSubSetSums( arr,  n, i+1, sum);
    }
}
