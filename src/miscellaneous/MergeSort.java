package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int arr[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mergesortRecursive(arr, 0, N - 1);
        //System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    static void mergesortRecursive(int arr[], int begin, int end) {
        if (begin==end) {
            return;
        }
            int mid = (end + begin) / 2;
            //Recursion's Dynamic Programming
            // sort left half
            mergesortRecursive(arr, begin, mid);
            // sort right half
            mergesortRecursive(arr, mid + 1, end);
            // merge both halfs
            merge(arr, begin, mid, end);

    }
    public static void merge(int arr[], int begin, int mid, int end) {
        int arr1[] = new int[mid - begin + 1];
        int arr2[] = new int[end - mid];

        //Populate left sub Array(first half).
        // As i starts from 0, i-begin will start from 0, and we will find subsequent indices for left sub array
        for (int i = begin; i <= mid; i++) {
            arr1[i - begin] = arr[i];
        }
        //Populate right sub Array(second half).
        // As i starts from 0, i-(mid+1) will start from 0, and we will find subsequent indices for right sub array
        for (int i = mid+1; i <= end; i++) {
            arr2[i - (mid+1)] = arr[i];
        }
        //Merging elements from both subArrays
        int i=0,j=0,k=begin;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }else{
                arr[k++]=arr2[j++];
            }
        }
        //if elements in first half's array still remain after Merge
        while(i<arr1.length){
            arr[k++]=arr1[i++];
        }
        //if elements in second half's array still remain after Merge
        while(j<arr2.length){
            arr[k++]=arr2[j++];
        }


    }

}
