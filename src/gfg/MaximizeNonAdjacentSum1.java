package gfg;

import java.util.Arrays;

public class MaximizeNonAdjacentSum1 {
    public static void main(String[] as) {
        int n = 5;
        int arr[] = {6, 5, 5, 7, 4};
        System.out.println(FindMaxSumTopBottom(arr, n));
    }

    public static int FindMaxSumTopBottom(int[] arr, int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        return calculate(0, arr, n, ans);

    }

    private static int calculate(int i, int[] arr, int n, int[] ans) {
        if (i >= n) {
            return 0;
        }
        if (ans[i] != -1) {
            return ans[i];
        }
        int takeChoice = arr[i] + calculate(i + 2, arr, n, ans);
        int doNotTakeChoice = calculate(i + 1, arr, n, ans);
        ans[i] = Math.max(takeChoice, doNotTakeChoice);
        return ans[i];
    }
    public static int FindMaxSumBottomTop(int arr[], int n) {

        int f=0,s=0,ans=0;
        f=Math.max(0,arr[0]);
        s=Math.max(f,arr[1]);
        for(int i=2;i<n;i++){
            int current=Math.max(arr[i]+f,s);
            f=s;
            s=current;
        }

        return s;



    }

}
