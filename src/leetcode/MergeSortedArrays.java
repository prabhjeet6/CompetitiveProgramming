package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**https://leetcode.com/problems/merge-sorted-array/description*/

public class MergeSortedArrays {
    public void merge_DriverFunctionNotSupported(int[] nums1, int m, int[] nums2, int n) {
    int i=0,j=0,shiftOffset=0;
    while(i<m&&j<n){
    if(nums1[i]<=nums2[j]){
        i++;
    }else{
       for(int k=m-1+shiftOffset;k>=i;k--){
           nums1[k+1]=nums1[k];
       }
       nums1[i]=nums2[j];
       j++;
       i++;
       shiftOffset++;
    }
    }
    if(i>=m&&j<n){
        while(j<n){
            //if(nums1[i]!=0){
                if(nums1[i]>nums2[j]){
                    nums1[i+1]=nums1[i];
                    nums1[i]=nums2[j];
                    j++;
                }
                i++;
                continue;
           // }
            //nums1[i]=nums2[j];
            //j++;
        }

    }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(bufferedReader.readLine());
        int n=Integer.parseInt(bufferedReader.readLine());
        int[]nums1=new int[m+n];
        int[]nums2=new int[n];
        nums1= Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        nums2= Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new MergeSortedArrays().merge(nums1,m,nums2,n);
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        //https://leetcode.com/problems/merge-sorted-array/solutions/3958223/java-runtime-0-ms-beats-100-o-m-n/?source=submission-noac
        int p1=m-1;
        int p2=n-1;
        int pMerge=m+n-1;
        while(p2>=0){
            if(p1>=0&&nums1[p1]>nums2[p2]){
                nums1[pMerge]=nums1[p1];
                pMerge--;
                p1--;
            }else{
                nums1[pMerge]=nums2[p2];
                pMerge--;
                p2--;
            }
        }
    }
}
