package miscellaneous;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HIndex2 {
    public static void main(String [] a) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bufferedReader.readLine());
        //sorted
        int[] citations= Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //bruteForce(citations);
        hIndexUsingBinarySearch(citations);
    }
    //Input:5
    //0 1 3 5 6
    //Output: 3
    //Given an array of Integers citations where citations[i] is number of citations a researcher
    //recieved for their ith paper and citations is sorted in ascending order, compute researcher's
    //H-Index.
    //A scientist has an h-index h if h of their n papers have at least h citations each, and
    // the other n−h papers have no more than h citations each.
    //If there are several possible values of h, max is taken as H-Index
    //Write an algorithm that runs in logarthmic time.
    static void  bruteForce(int [] citations){
        int maxCitations=0,hIndex=0;
        for(int citation:citations){
           maxCitations=Math.max(maxCitations,citation);
        }

        for(int i=0;i<=maxCitations;i++){
            int atLeastICitations=0,noMoreThanICitations=0;
            for(int j=0;j<citations.length;j++) {
                if (citations[j] >= i) {
                    atLeastICitations++;
                }
                if (citations[j] < i) {
                    noMoreThanICitations++;
                }
            }
            if (atLeastICitations>=i&&noMoreThanICitations<=(citations.length-i)){
                hIndex=Math.max(hIndex,i);
            }
        }
        System.out.print(hIndex);
    }
    static void hIndexUsingBinarySearch(int [] citations){
        int low=0,high=citations.length-1,mid=0,hIndex=0;
        while (low<=high){
            mid=(low+high)/2;
            if(hIndex<high-mid+1){
                hIndex=high-mid+1;
                high=mid-1;
            }
        }
    }
}
