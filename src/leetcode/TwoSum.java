package leetcode;

import java.util.*;

class TwoSum {
    public static void main(String as[]) {
        System.out.println(Arrays.toString(twoSumHashMap(new int[]{3, 3}, 6)));
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public int[] twoSumHashMapOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                ans[0] = i;
                ans[1] = map.get(complement);
            }
            map.put(nums[i], i);
        }


        return ans;
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumTwoPointers(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int result[] = new int[2];
        int numsCopy[] = new int[nums.length];
        numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        //Map<Integer,Integer>indicesMap=new HashMap<>();
        int lNums = 0, rNums = 0;

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                //result[0]=indicesMap.get(nums[l]);
                //result[1]=indicesMap.get(nums[r]);
                lNums = nums[l];
                rNums = nums[r];
                break;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numsCopy[i] == lNums) {
                result[counter] = i;
                counter++;
            } else if (numsCopy[i] == rNums) {
                result[counter] = i;
                counter++;
            }

        }
        return result;
    }

    public int[] twoSumBinarySearch(int[] nums, int target) {
        int[] numsCopy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(nums);
        int lNums = 0, rNums = 0;
        int[] indices = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            boolean secondVal = binarySearch(i + 1, nums.length - 1, target - nums[i], nums);
            if (secondVal) {
                lNums = nums[i];
                rNums = target - nums[i];
                break;
            }
        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lNums == numsCopy[i]) {
                indices[counter] = i;
                counter++;
            } else if (rNums == numsCopy[i]) {
                indices[counter] = i;
                counter++;
            }
        }

        return indices;
    }

    boolean binarySearch(int low, int high, int target, int nums[]) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
