package miscellaneous;


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class IndexOfExtraElement {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] big = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] small = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //bruteForce(small,big,n);
        System.out.print(findExtraElementUsingBinarySearch(small,big));
    }


    static void bruteForce(int[] small, int[] big, int n) {
        int i = 0;
        boolean found = false;
        for (i = 0; i < n - 1; i++) {
            if (big[i] != small[i]) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.print(i);
        } else {
            System.out.print(n - 1);
        }
    }
    /* Lets take a example to understand this.
        Ex: arr1 =  [1,4,5,6,7,9,10],
        arr2 = [1,4,5,6,7,8,9,10]
        If the elements match at a given index, it means the extra element is further to the right.
        Ex: let say mid = 2 then arr1[2] = 5 and arr2[2] = 5, here you can
        see the extra element is at right.

        If the elements differ at a given index, the extra element must be at this index or earlier.
        Ex: let say mid = 6 then arr1[6] = 10 and ar2[6] = 9. here you can
        see the extra element is at left

        Perform binary search to identify where the first mismatch occurs, which indicates the index
        of the extra element.*/
    static int findExtraElementUsingBinarySearch(int[] small, int[] big) {
        int low = 0, mid = 0, high = small.length - 1;
        while (low <= high) {
            //prevents overflow
            mid = low + (high - low) / 2;
            if (small[mid] == big[mid]) {
                //mismatch is at  right side
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return low;
    }

}