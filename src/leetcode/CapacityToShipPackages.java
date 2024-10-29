package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/1437202753/
public class CapacityToShipPackages {
    public static void main(String[] a) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int days = Integer.parseInt(bufferedReader.readLine());
            System.out.println(findLeastMaxCapacityUsingBinarySearch(nums, days));
        }
    }

    static int findMaxWeight(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    static int findTotalWeight(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    static boolean isFeasible(int mid, int[] nums, int days) {
        int sumWeights = 0, countDays = 1;
        for (int num : nums) {
            if (sumWeights + num <= mid) {
                //weights can be accommodated in a single day
                sumWeights += num;
            } else {
                //count a different day with weight sum calculation done afresh.
                sumWeights = num;
                countDays++;
            }
        }
        //if countDays does not exceed input number of days, this mid is a feasible
        // leastMaxWeightCapacity
        return days >= countDays;
    }

    //Here, array may not be sorted, rather we need a monotonic space
    //BinarySearch on answer/monotonic space. Here, desired answer is leastMaxCapacityOfContainer
    //monotonic space will be upon the possible low and high values of capacity
    static int findLeastMaxCapacityUsingBinarySearch(int[] nums, int days) {
        int low = findMaxWeight(nums);
        int high = findTotalWeight(nums);
        int mid = 0;
        while (low <= high) {
            //prevents overflow
            mid = low + (high - low) / 2;
            boolean isFeasible = isFeasible(mid, nums, days);
            if (!isFeasible) {
                //need to increase mid(leastMaxCapacity) as current mid will take more days than allotted
                low = mid + 1;
            } else {
                //Feasible
                //try reducing weight (leastMaxCapacity)
                isFeasible = isFeasible(mid - 1, nums, days);
                if (!isFeasible) {
                    //if at a reduced weight, that is, mid-1, it is not feasible and at mid it was
                    // feasible, then mid is out answer
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return mid;
    }
}
