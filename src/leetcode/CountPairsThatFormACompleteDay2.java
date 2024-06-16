package leetcode;


import java.util.*;
import java.io.*;
import java.math.*;

class CountPairsThatFormACompleteDay2 {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int rem = 0;
        long count = 0l;
        //10 21 27
        for (int hour : hours) {
            rem = hour % 24;
            int complement = (24 - rem) % 24;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}