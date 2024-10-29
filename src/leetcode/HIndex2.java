package leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//https://leetcode.com/problems/h-index-ii/description/
public class HIndex2 {
    public static void main(String[] a) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        //sorted
        int[] citations = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
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
    static void bruteForce(int[] citations) {
        int maxCitations = 0, hIndex = 0;
        for (int citation : citations) {
            maxCitations = Math.max(maxCitations, citation);
        }

        for (int i = 0; i <= maxCitations; i++) {
            int atLeastICitations = 0, noMoreThanICitations = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    atLeastICitations++;
                }
                if (citations[j] < i) {
                    noMoreThanICitations++;
                }
            }
            if (atLeastICitations >= i && noMoreThanICitations <= (citations.length - i)) {
                hIndex = Math.max(hIndex, i);
            }
        }
        System.out.print(hIndex);
    }

    /**
     * Suppose you are given an array of citations sorted in ascending order, for example:
     * [0, 1, 3, 5, 6]. The h-index can be found by checking if the number of papers with at least
     * h citations is equal to or greater than h.
     * <p>
     * For the array [0, 1, 3, 5, 6], the correct h-index is 3, because there are 3 papers with at
     * least 3 citations.
     * Since the array is already sorted, a binary search can be used to find the maximum h-index
     * efficiently in O(log n) time. Here's how it works:
     * <p>
     * Use binary search over the indices of the citations array. We want to find the maximum h where
     * the researcher has at least h papers with h or more citations.
     * Let low = 0 and high = n - 1 (where n is the length of the array).
     * <p>
     * For each midpoint mid, calculate the number of papers that have at least citations[mid] citations.
     * The number of papers with at least citations[mid] citations is given by n - mid (because
     * the array is sorted).
     * Check if citations[mid] is greater than or equal to n - mid. If it is, this means the current
     * paper can potentially be the h-index (because there are n - mid papers with at least
     * citations[mid] citations).
     * If true, this is a valid candidate for h-index, so we continue searching in the left half
     * (high = mid - 1) to check if a higher h-index can be found.
     * If false, we move to the right half (low = mid + 1) to find a larger h value.
     **/

    static void hIndexUsingBinarySearch(int[] citations) {
        int low = 0, high = citations.length - 1, mid = 0, hIndex = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            //The number of papers with citations greater than or equal to citations[mid] should be
            // calculated as citations.length - mid. This correctly counts how many papers meet
            // the h-index requirement for that mid citation count, as high will keep on changing
            if (citations[mid] >= (citations.length - mid)) {
                hIndex = Math.max(hIndex, citations.length - mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.print(hIndex);
    }
}
