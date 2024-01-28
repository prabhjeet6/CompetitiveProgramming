package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class PeakElement {
/**https://leetcode.com/problems/find-peak-element/description/*/
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(bufferedReader.readLine().trim());
        long arr[] = new long[Math.toIntExact(N)];

        arr = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(binarySearchReturnsReturnsIndexOfAnyPeakElementOfUnsortedArray(arr));
    }

    static int binarySearchReturnsReturnsIndexOfAnyPeakElementOfUnsortedArray(long arr[]) {
        int mid = 0, low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
                if(arr.length==1){
                    return 0;
                }else if(mid==0&&arr[mid] >= arr[mid + 1] ){
                    return mid;
                }else if(mid==arr.length-1&&arr[mid] >= arr[mid - 1]){
                    return mid;
                }
                else if ((mid != 0 && mid != arr.length - 1) && arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1]) {
                    return mid;
                } else if ((mid != arr.length - 1) && arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else if ((mid != 0) && arr[mid] < arr[mid - 1]) {
                    high = mid - 1;
                } else {
                    high = mid - 1;
                }
            }

        return -1;
    }
}
