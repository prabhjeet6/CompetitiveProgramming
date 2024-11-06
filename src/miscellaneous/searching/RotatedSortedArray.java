package miscellaneous.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class RotatedSortedArray {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(bufferedReader.readLine().trim());
        long arr[] = new long[Math.toIntExact(N)];
        arr = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Long T = Long.parseLong(bufferedReader.readLine().trim());
        Long[] searchKeys = new Long[Math.toIntExact(T)];
        int pivotIndex=findPivotElemenIndex(arr);
        for (int i = 0; i < T; i++) {
            searchKeys[i] = Long.parseLong(bufferedReader.readLine().trim());
        }
        for (int i = 0; i < T; i++) {
            if(pivotIndex==-1){
                System.out.println(binarySearch(arr,searchKeys[i],0,arr.length-1));
            }else{
                if(arr[pivotIndex]==searchKeys[i])
                    System.out.println(pivotIndex);
                else{
                    if(arr[arr.length-1]<searchKeys[i]){
                        System.out.println(binarySearch(arr,searchKeys[i],0,pivotIndex));
                    }else{
                        System.out.println(binarySearch(arr,searchKeys[i],pivotIndex+1,arr.length-1));
                    }
                }
            }
        }
    }

    static int findPivotElemenIndex(long arr[]) {
        int mid = 0, low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if ((mid!=0&&mid!=arr.length-1)&&arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1] ) {
                return mid;
            } else if (arr[mid] >arr[arr.length-1]) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    static int binarySearch(long arr[], Long searchKey,int low,int high) {
        while (low <= high) {
         int    mid = (low + high) / 2;
            if (arr[mid] == searchKey) {
                return mid;
            } else if (arr[mid] < searchKey) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
