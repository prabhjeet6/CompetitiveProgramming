package miscellaneous.sorting;

public class RadixSort {

    static int getMax(int[] a, int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max; //maximum element from the array
    }

    static void countingSort(int a[], int n, int place) // function to implement counting sort
    {
        int[] output = new int[n + 1];
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < n; i++)
            count[(a[i] / place) % 10]++;

        // Calculate cumulative frequency
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[(a[i] / place) % 10] - 1] = a[i];
            count[(a[i] / place) % 10]--;
        }

        for (int i = 0; i < n; i++)
            a[i] = output[i];
    }

    // function to implement radix sort
    public static void radixsort(int a[], int n) {

        // get maximum element from array
        int max = getMax(a, n);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(a, n, place);
    }

    // function to print array elements
    static void printArray(int a[], int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print("  " + a[i]);
        }
        System.out.print("\n");
    }

    public static void main(String[] ad) {
        int[] a = {181, 289, 390, 121, 145, 736, 514, 888, 122};
        int n = a.length;
        System.out.print("Before sorting array elements are - \n");
        printArray(a, n);
        radixsort(a, n);
        System.out.print("After applying Radix sort, the array elements are - \n");
        printArray(a, n);
    }
}