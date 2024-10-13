package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://codeforces.com/problemset/problem/118/B
public class PresentFromLena {
    public static void main(String[] a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        hankerChiefPatternPart1(n);
        hankerChiefPatternPart2(n );
    }


    static void hankerChiefPatternPart1(int n) {
        for (int j = n + 1; j >= 0; j--) {
            System.out.print(" ");
        }
        System.out.println("0 ");
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            System.out.print(0 + " ");
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.print(0 + " ");
            System.out.println();
        }

    }

    static void hankerChiefPatternPart2(int n) {
        int lower=n;
        for (int i = 1; i <= n; i++) {
            for (int j =  1; j <=i; j++) {
                System.out.print(" ");
            }
            System.out.print(0 + " ");
            for (int j = 1; j <lower; j++) {
                System.out.print(j + " ");
            }
            lower--;
            for (int j = lower-1; j >= 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}

