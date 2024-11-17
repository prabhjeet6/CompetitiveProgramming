package miscellaneous.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class UnionOfTwoSortedArrays {
    public static void main(String[] a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        int[] nums1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bruteForce2(nums1, nums2);
    }

    static void bruteForce2(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int l=0,r=0;
        List<Integer> ls = new ArrayList<>();
        while (l < m && r < n) {
            if (nums1[l] < nums2[r]) {
                if(!ls.contains(nums1[l])) {
                    ls.add(nums1[l]);
                }
                l++;
            } else if (nums1[l] > nums2[r]) {
                if(!ls.contains(nums2[r])) {
                    ls.add(nums2[r]);
                }
                r++;
            } else {
                if (nums1[l] == nums2[r]) {
                    if(!ls.contains(nums1[l])) {
                        ls.add(nums1[l]);
                    }
                    l++;
                    r++;
                }
            }
        }
        while (l < m) {
            ls.add(nums1[l]);
            l++;
        }
        while (r < n) {
            ls.add(nums2[r]);
            r++;
        }

        for (int num : ls) {
            System.out.print(num + " ");
        }
    }


    static void bruteForce(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set.add(num);
        }
        for (int num : set) {
            System.out.print(num + " ");
        }
    }
}
