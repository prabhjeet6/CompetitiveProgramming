package leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=SOI-ZzYemoc
public class FlipColumnsForMaximumNumberOfEquals {
    //Max Equal rows can be found by counting the rows with the same values or inverted values. Refer video in case of doubt
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int maxEqualRows = 0;
        for (int[] ints : matrix) {
            StringBuilder row = new StringBuilder();
            StringBuilder invertedRow = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                row.append(ints[j]);
                invertedRow.append(1 - ints[j]);
            }
            map.put(row.toString(), map.getOrDefault(row.toString(), 0) + 1);
            map.put(invertedRow.toString(), map.getOrDefault(invertedRow.toString(), 0) + 1);
        }
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder invertedRow = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                row.append(matrix[i][j]);
                invertedRow.append(1 - matrix[i][j]);
            }
            int sum = 0;
            if (map.containsKey(row.toString())) {
                sum += map.get(row.toString());
            } else {
                sum += map.get(invertedRow.toString());
            }
            maxEqualRows = Math.max(maxEqualRows, sum);
        }
        return maxEqualRows;
    }
}
