package gfg;


import java.util.HashMap;
import java.util.HashSet;

class EquivalentSubArrays {
    public static void main(String[] arg) {
        System.out.println(countDistinctSubarray(new int[]{2, 2, 1, 10, 6, 1, 7, 2, 5, 1, 8, 5, 3, 1, 2, 9, 2, 10, 7, 6, 5, 2}, 22));
        System.out.println(countDistinctSubarray(new int[]{2, 1, 3, 2, 3}, 5));
        System.out.println(countDistinctSubarray(new int[]{2, 4, 4, 2, 4}, 5));

    }

    static int countDistinctSubarray(int a[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        int i = 0;
        for (int j = 0; j < n; j++) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);
            while (map.size() == set.size()) {
                count += n - j;
                map.put(a[i], map.get(a[i]) - 1);
                if (map.get(a[i]) == 0) {
                    map.remove(a[i]);
                }
                i++;
            }
        }
        return count;
    }
}