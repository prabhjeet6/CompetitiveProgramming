package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class SortBasedOnEquation {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            long[] ABC = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long A = ABC[0];
            long B = ABC[1];
            long C = ABC[2];
            long N = Integer.parseInt(bufferedReader.readLine());
            long[] arr = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            sortBasedOnEquation(arr, A, B, C);
        }

    }

    private static void sortBasedOnEquation(long[] arr, long A, long B, long C) {
        for (int i = 0; i < arr.length; i++) {
            long temp = A * arr[i] * arr[i] + B * arr[i] + C;
            arr[i] = temp;
        }
        int pivot = -1, c = 0, p1 = -1, p2 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (A < 0) {
                if (i != arr.length - 1 && arr[i + 1] < arr[i]) {
                    pivot = i + 1;
                    p1 = 0;
                    p2 = arr.length - 1;
                    break;
                }
            } else {
                if (i != arr.length - 1 && arr[i + 1] > arr[i]) {
                    pivot = i + 1;
                    p2 = pivot;
                    p1 = pivot - 1;
                    break;
                }
            }
        }
        if (pivot == -1 || p1 == -1 || p2 == -1) {
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
        } else {
            long resultant[] = new long[arr.length];
            if (A < 0) {
                while (p1 <= pivot && p2 >= pivot) {
                    if (arr[p2] < arr[p1]) {
                        resultant[c] = arr[p2];
                        c++;
                        p2--;
                    } else {
                        resultant[c] = arr[p1];
                        c++;
                        p1++;
                    }
                }
            } else {
                while (p1 >= 0 && p2 <= arr.length) {
                    if (arr[p2] < arr[p1]) {
                        resultant[c] = arr[p2];
                        c++;
                        p2++;
                    } else {
                        resultant[c] = arr[p1];
                        c++;
                        p1--;
                    }
                }
            }
            if (A < 0) {
                if (p1 <= pivot) {
                    while (p1 <= pivot) {
                        resultant[c] = arr[p1];
                        c++;
                        p1++;
                    }
                } else {
                    while (p2 >= pivot) {
                        resultant[c] = arr[p1];
                        c++;
                        p2--;
                    }
                }
            } else {
                if (p1 >= 0) {
                    while (p1 >= 0) {
                        resultant[c] = arr[p1];
                        c++;
                        p1--;
                    }
                } else {
                    while (p2 <= arr.length) {
                        resultant[c] = arr[p2];
                        c++;
                        p2++;
                    }
                }
            }
            System.out.println(Arrays.toString(resultant));
        }
    }

    private static void sortBasedOnEquationBruteForce(long[] arr, long A, long B, long C) {
        for (int i = 0; i < arr.length; i++) {
            long temp = A * arr[i] * arr[i] + B * arr[i] + C;
            arr[i] = temp;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
