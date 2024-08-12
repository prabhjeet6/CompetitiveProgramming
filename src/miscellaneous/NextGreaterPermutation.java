package miscellaneous;

import java.lang.*;
import java.io.*;
import java.util.Arrays;

public class NextGreaterPermutation {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        while (T > 0) {
            T--;
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] input = bufferedReader.readLine().split(" ");
            int[] inputPermutation = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                inputPermutation[i] = Integer.parseInt(input[i]);
            }
            int swapIndex1 = -1, swapIndex2 = -1;
            for (int i = inputPermutation.length - 1; i - 1 >= 0; i--) {
                if (inputPermutation[i] > inputPermutation[i - 1]) {
                    swapIndex1 = i-1;
                    break;
                }
            }
            if (swapIndex1 != -1) {
                for (int i = inputPermutation.length - 1; i >= swapIndex1 + 1; i--) {
                    if (inputPermutation[i] > inputPermutation[swapIndex1]) {
                        swapIndex2 = i;
                        break;
                    }
                }
                if (swapIndex1 != -1 && swapIndex2 != -1) {
                    swap(inputPermutation, swapIndex1, swapIndex2);
                }
                if (swapIndex1 != -1) {
                    int left = swapIndex1+1;
                    int right = inputPermutation.length - 1;
                    while (left <= right) {
                        swap(inputPermutation, left, right);
                        left++;
                        right--;
                    }
                }
            }else{
                Arrays.sort(inputPermutation);
            }

            for (int i = 0; i < inputPermutation.length; i++) {
                System.out.print(inputPermutation[i] + " ");
            }
            System.out.println();
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}