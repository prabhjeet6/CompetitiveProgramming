package miscellaneous.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;


public class BinarySearch {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(bufferedReader.readLine().trim());
        long arr[] = new long[Math.toIntExact(N)];
        arr = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Long T = Long.parseLong(bufferedReader.readLine().trim());
        Long[] searchKeys=new Long[Math.toIntExact(T)];
        for (int i = 0; i <T; i++) {
             searchKeys[i]=Long.parseLong(bufferedReader.readLine().trim());
        }
        for(int i=0;i<T;i++){
            //Frequency Of SearchKey in Search Space
            if(binarySearchReturnsLastOccurrenceOfSearchKey(arr, searchKeys[i])==-1)
                System.out.println(0);
            else
                System.out.println(binarySearchReturnsLastOccurrenceOfSearchKey(arr, searchKeys[i])-binarySearchReturnsFirstOccurrenceOfSearchKey(arr,searchKeys[i])+1);
        }
    }

    static int binarySearchReturnsMinusOneIfSearchKeyNotFound(long arr[], Long searchKey) {
        int mid = 0, low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
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
    static int binarySearchReturnsInsertionPointIfSearchKeyNotFound(long arr[], Long searchKey) {
        int mid = 0, low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == searchKey) {
                return mid;
            } else if (arr[mid] < searchKey) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    static int binarySearchReturnsFirstOccurrenceOfSearchKey(long arr[], Long searchKey) {
        int mid = 0, low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == searchKey) {
                if(mid==0)
                    return mid;
                else if(arr[mid-1]!=searchKey)
                    return mid;
                else high=mid-1;
            } else if (arr[mid] < searchKey) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    static int binarySearchReturnsLastOccurrenceOfSearchKey(long arr[], Long searchKey) {
        int mid = 0, low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == searchKey) {
               if(mid==arr.length-1)
                   return mid;
               else if(arr[mid+1]!=searchKey)
                   return mid;
               else low=mid+1;
            } else if (arr[mid] < searchKey) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
