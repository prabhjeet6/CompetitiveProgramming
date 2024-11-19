package miscellaneous.sorting;

public class CountSort {
    static void countSort(int[] arr, int n) {

        int max = 0, min = n * n;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] freq = new int[max - min + 1];
        //calculate freq
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }
        //calculate cumulative frequency
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        int[] ans = new int[n];

        //40 12 45 32 33 1 22

        for (int i = n - 1; i >= 0; i--) {
            ans[freq[arr[i] - min] - 1] = arr[i];
            freq[arr[i] - min]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }
}
