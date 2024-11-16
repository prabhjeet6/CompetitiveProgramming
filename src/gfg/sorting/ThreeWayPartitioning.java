package gfg.sorting;


import java.util.Arrays;

class ThreeWayPartitioning {


    public static void main(String[] as) {
        int[] a = new int[]{1, 2, 3, 3, 4};
        threeWayPartition(a, 1, 2);
        System.out.println(Arrays.toString(a));
    }

    //Function to partition the array around the range such
    //that array is divided into three parts.
    static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    // refer to Partitioning notes on PPA
    public static void threeWayPartition(int[] array, int a, int b) {

        int lessThanA = 0, aToB = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < a) {
                lessThanA++;
            } else if (array[i] >= a && array[i] <= b) {
                aToB++;
            }
        }
        int moreThanBCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (!(array[i] > b)) {
                if (i != moreThanBCount) {
                    swap(array, i, moreThanBCount);
                }
                moreThanBCount++;
            }
        }
        int count = 0;
        for (int i = 0; i < (lessThanA + aToB); i++) {
            if (!(array[i] >= a && array[i] <= b)) {
                if (i != count) {
                    swap(array, i, count);
                }
                count++;
            }
        }
    }
}