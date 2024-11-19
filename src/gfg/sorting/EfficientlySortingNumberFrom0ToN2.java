package gfg.sorting;

//https://www.geeksforgeeks.org/problems/efficiently-sorting-number-from-0-to-n2-15444/1

import java.util.Arrays;

import static miscellaneous.sorting.RadixSort.radixsort;

class EfficientlySortingNumberFrom0ToN2 {
    public static void sort(int arr[], int n) {
        radixsort(arr, n);
    }
}