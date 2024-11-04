package gfg;


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
//https://www.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
class ValueFreqModel {
    int val;
    int freq;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ValueFreqModel && this.val == ((ValueFreqModel) obj).val && this.freq == ((ValueFreqModel) obj).freq;
    }
}

class ValueFreqModelComparator implements Comparator<ValueFreqModel> {
    //2
//5
//5 5 4 6 4
//5
//9 9 9 2 5
    @Override
    public int compare(ValueFreqModel o1, ValueFreqModel o2) {
        if (o1.freq != o2.freq) {
            return Integer.compare(o2.freq, o1.freq);
        }
        return Integer.compare(o1.val, o2.val);
    }
}

class SortingElementsOfArrayByFrequency {
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(bf.readLine());
            int[] nums = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> freqs = new HashMap<>();
            for (int num : nums) {
                freqs.put(num, freqs.getOrDefault(num, 0) + 1);
            }
            List<ValueFreqModel> list = new ArrayList<>();
            for (int num : nums) {
                ValueFreqModel model = new ValueFreqModel();
                model.val = num;
                model.freq = freqs.get(num);
                if (!list.contains(model)) {
                    list.add(model);
                }
            }
            list.sort(new ValueFreqModelComparator());
            for (ValueFreqModel model : list) {
                for (int i = 0; i < model.freq; i++) {
                    System.out.print(model.val + " ");
                }
            }
            System.out.println();
        }
    }
}