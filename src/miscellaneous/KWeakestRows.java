package miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SoldiersInRow{
    int numberOfSoldiers;
    int rowNum;
}
class SoldiersInRowComparator implements Comparator<SoldiersInRow>{

    @Override
    public int compare(SoldiersInRow o1, SoldiersInRow o2) {
        if(o1.numberOfSoldiers!=o2.numberOfSoldiers){
            return Integer.compare(o1.numberOfSoldiers,o2.numberOfSoldiers);
        }else{
            return Integer.compare(o1.rowNum,o2.rowNum);
        }
    }
}


public class KWeakestRows {
    public static void main(String[] args) throws java.lang.Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        List<SoldiersInRow> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            SoldiersInRow soldiersInRow=new SoldiersInRow();
            //in case, binary search returns -1, that is, there are no 1s then, number of soldiers become 0
            soldiersInRow.numberOfSoldiers=binarySearch(matrix[i])+1;
            soldiersInRow.rowNum=i;
            list.add(soldiersInRow);
        }
        Collections.sort(list,new SoldiersInRowComparator());
        for(SoldiersInRow soldiersInRow:list){
            System.out.print(soldiersInRow.rowNum+" ");
        }
    }
    //search for the last index at which '1' can be found
    static int binarySearch(int[] arr){
        int low=0,high=arr.length-1,mid=0;
        while(low<=high) {
            mid=(low+high)/2;
            if (arr[mid]==0){
                high=mid-1;
            }else{
                if(mid!=arr.length-1&&arr[mid+1]==1){
                    low=mid+1;
                }else{
                    break;
                }
            }
        }
        //if there are only zeros in the row, then we return -1 indicating that there are no 1s
        return arr[mid]==1?mid:-1;
    }

}
