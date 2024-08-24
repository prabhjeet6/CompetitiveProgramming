package hackerrank;

import java.util.Scanner;
import java.util.Stack;


public class NeedAllOnes {

//https://www.hackerrank.com/contests/gl-bajaj-self-evaluation-contest/challenges/need-all-ones/problem
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        int[] nle = new int[m];
        int[] ple = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (i != 0 && arr[i][j] != 0) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        st.push(0);

        int i = n - 1;

        for (int j = 1; j < m; j++) {
            if (arr[i][j] > arr[i][st.peek()]) {
                st.push(j);
            } else {
                while (!st.isEmpty() && arr[i][st.peek()] > arr[i][j]) {
                    nle[st.peek()] = j;
                    st.pop();
                }
                st.push(j);
            }
        }
        while (!st.isEmpty()) {
            nle[st.peek()] = m;
            st.pop();
        }
        st.push(m - 1);
        for (int j = m - 2; j >= 0; j--) {
            if (arr[i][j] > arr[i][st.peek()]) {
                st.push(j);
            } else {
                while (!st.isEmpty() && arr[i][st.peek()] > arr[i][j]) {
                    ple[st.peek()] = j;
                    st.pop();
                }
                st.push(j);
            }
        }
        while (!st.isEmpty()) {
            ple[st.peek()] = -1;
            st.pop();
        }

        int ma = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            int h = (nle[j] - ple[j] - 1) * arr[i][j];
            ma = Math.max(ma, h);
        }
        System.out.println(ma);
    }
}