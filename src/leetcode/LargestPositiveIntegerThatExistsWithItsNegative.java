package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02**/
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String arg[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxTwoPassHashSet(arr));
    }

    public int findMaxKBruteForce(int[] nums) {
        //o(n^2)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 0 && max < Math.abs(nums[i])) {
                    max = Math.abs(nums[i]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public int findMaxKTwoPointers(int[] nums) {
        //O(nlogn)
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == 0) {
                return nums[high];
            }
            //-7+9
            else if (nums[low] + nums[high] > 0) {
                high--;
            } else {
                //-7+5
                low++;
            }

        }
        return -1;
    }

    /**
     * Approach 3: Two Pass Hash Set
     * Intuition
     * In the brute force approach, we sacrificed runtime to find the solution.
     * The key insight from this approach was to use nested loops to search for the negative versions of
     * positive numbers. If we search for values without traversing the entire range, we can eliminate the
     * need for the nested loop. This implies the necessity of a data structure with constant lookup time (O(1)
     * , allowing us to store all negative numbers encountered during the first pass.
     *
     * On average, the contains() of HashSet runs in O(1) time. Getting the object’s bucket location is a
     * constant time operation. Taking into account possible collisions, the lookup time may rise to log(n)
     * because the internal bucket structure is a TreeMap.
     *
     * This is an improvement from Java 7 which used a LinkedList for the internal bucket structure. In general, hash code collisions are rare. So we can consider the elements lookup complexity as O(1).
     * <p>
     * The idea is to use a hash set to store all negative numbers encountered in the first pass.
     * Then, in the second pass, we can check if the negatives of the positive numbers exist in the hash set
     * and update the maximum value accordingly.
     *
     **/
    public int findMaxTwoPassHashSet(int nums[]) {
        //TC O(n) SC O(n)
        Set<Integer> negativeNumbers = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeNumbers.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && negativeNumbers.contains(-1 * nums[i])) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
    public int findMaxOnePassHashSet(int nums[]) {
        //TC O(n) SC O(n)
        Set<Integer> visited = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i])>max&&visited.contains(nums[i]*-1)) {
                max=Math.abs(nums[i]);
            }
            visited.add(nums[i]);
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }

}


