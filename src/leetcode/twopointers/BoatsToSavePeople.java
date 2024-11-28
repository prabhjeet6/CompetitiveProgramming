package leetcode.twopointers;

import java.util.Arrays;


class BoatsToSavePeople {
    public static void main(String[] a) {
        System.out.println(numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length, l = 0, r = n - 1;
        int count = 0;
        while (l <= r) {
            //minimize the number of boats
            int sum = people[l] + people[r];
            if (sum <= limit) {
                l++;
            }
            r--;
            count++;
        }

        return count;
    }

}