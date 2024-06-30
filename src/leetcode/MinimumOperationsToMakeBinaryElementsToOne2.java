package leetcode;


class MinimumOperationsToMakeBinaryElementsToOne2 {
    //Gives TLE
    public int minOperationsBruteForce(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = i; j < n; j++) {
                    nums[j] = 1 - nums[j];
                }
            }
        }
        return count;
    }

    //keep track of number of zeros encountered, if number of zeros Encountered before current index,
    // following bits will be flipped, but, not otherwise
    public int minOperations(int[] nums) {
        int n = nums.length, numberOfZerosEncountered = 0;
        for (int i = 0; i < n; i++) {
            if (numberOfZerosEncountered % 2 == 1) {
                nums[i] = 1 - nums[i];
            }
            if (nums[i] == 0) {
                numberOfZerosEncountered++;
            }

        }
        return numberOfZerosEncountered;
    }
}