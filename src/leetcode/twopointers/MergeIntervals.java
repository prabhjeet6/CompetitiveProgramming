package leetcode.twopointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.youtube.com/watch?v=2JzRBPFYbKE
class MergeIntervals {
    public static void main(String[] as) {
        int[][] intervals = {{1, 10},{2, 3},{4, 5},{6, 7},{8, 9}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        //sort the intervals in ascending order
        Arrays.sort(intervals, (x, y) ->  x[0] - y[0]);
        List<int[]> ans = new ArrayList<>();
        //initialize left and right bounds with first values
        int leftBound = intervals[0][0], rightBound = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            //if previous interval's rightBound is greater than equal to current interval's left
            // bound(overlap), merge intervals
            //imp: always compare the merged right bound with next interval's left bound
            if (i + 1 < intervals.length && rightBound >= intervals[i + 1][0]) {
                leftBound = Math.min(leftBound, intervals[i + 1][0]);
                rightBound = Math.max(rightBound, intervals[i + 1][1]);
            } else {
                //if there is no overlap, add left and right bounds to ans, and reinitialize these bounds
                //with next nterval values
                ans.add(new int[]{leftBound, rightBound});
                if (i + 1 < intervals.length) {
                    leftBound = intervals[i + 1][0];
                    rightBound = intervals[i + 1][1];
                }
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
