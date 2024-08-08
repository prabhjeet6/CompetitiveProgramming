package leetcode;

//https://leetcode.com/problems/reverse-pairs/

//https://www.youtube.com/watch?v=S6rsAlj_iB4
public class SpecialInversions {
    public static void main(String[] asd) {
        int[] nums = {1, 3, 2, 3, 1};

       
        System.out.println(reversePairs(nums));
    }

    //TC:O(N^2) SC: O(1)
    public static int reversePairsBruteForce(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    //Inversion Count(0, N-1) = Inversion Count(0, m) + Inversion Count(m+1, N-1) + InterArray Inversion Count(0, m, m+1, N-1)
    //TC:O(NlogN) SC:O(N)
    public static int reversePairs(int[] nums) {
        int l = 0, r = nums.length-1;
        return mergeSort(l, r, nums);
    }


    private static int mergeSort(int l, int r, int[] nums) {

        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2;
        int count = 0;
        //Divide and Conquer
        count += mergeSort(l, m, nums);
        count += mergeSort(m + 1, r, nums);
        count += merge(l, m, r, nums);
        return count;
    }

    private static int merge(int l, int m, int r, int[] nums) {
        int count=0;
        int j=m+1;
        for(int i=l;i<=m;i++){
            while(j<=r&&nums[i]>(2*(long)nums[j])){
                j++;
            }
            count+=j-(m+1);
        }



        int n1 = m - l + 1;
        int n2 = r - (m + 1) + 1;

        int[] leftNums = new int[n1];
        int[] rightNums = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftNums[i] = nums[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rightNums[i] = nums[m +1+ i];
        }
        int l1 = 0, l2 = 0, l3 = l;
        while (l1 < n1 && l2 < n2) {
            if (leftNums[l1] <= rightNums[l2]) {
                nums[l3++] = leftNums[l1++];
            } else {
                nums[l3++] = rightNums[l2++];
            }
        }
        while (l1 < n1) {
            nums[l3++] = leftNums[l1++];
        }
        while (l2 < n2) {
            nums[l3++] = rightNums[l2++];
        }
        return count;
    }
}
