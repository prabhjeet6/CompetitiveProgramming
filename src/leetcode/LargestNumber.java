package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] a) {

        System.out.println(largestNumber(new int[]{34323, 3432}));
    }

    static String largestNumber(int[] nums) {
        List<String> numStrings = new ArrayList<>();
        for (int num : nums) {
            numStrings.add(String.valueOf(num));
        }
        //reverse sort on concatenation
        Collections.sort(numStrings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        //if after sorting(Lexicographical), the first element is 0, then all elements are zero and
        // resulting String should be zero
        if (numStrings.get(0).equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String s : numStrings) {
            result.append(s);
        }
        return result.toString();
    }
}



