package miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class RepeatingElement {

    public static void main(String asd[]) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(bufferedReader.readLine().trim());
        long arr[] = new long[Math.toIntExact(N)];

        arr = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(binarySearchReturnsOnlyRepeatingElement(arr));

    }

    static Long binarySearchReturnsOnlyRepeatingElement(long arr[]) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid == 0 && arr[mid + 1] == arr[mid])
                return arr[mid];
            else if (mid == arr.length - 1 && arr[mid - 1] == arr[mid])
                return arr[mid];
            else{
                if(arr[mid]==mid+1){
                    low=mid+1;
                }else if(arr[mid]==mid){
                    if(arr[mid-1]==arr[mid])
                        return arr[mid];
                    else high=mid-1;
                }
            }
        }

        return -1l;

    }
}

