package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class SumOfMinimums {
    static int sum=0;
    public static int sumSubarrayMins(int[] arr) {

        int[]nse=nextSmallerNumber(arr);
        int[]psoe=previousSmallerOrEqualNumber(arr);
        int mod=1000000007;
        for(int i=0;i<arr.length;i++){
            int contributingSubArrays=((i - psoe[i])%mod * (nse[i] - i)%mod)%mod;
            int contribution=(arr[i]%mod *contributingSubArrays%mod)%mod;
            sum = (sum%mod+contribution % mod)%mod;
            System.out.println(arr[i]+" "+contributingSubArrays+" "+contribution+" "+sum);
        }
        return sum;
    }

    static int[] nextSmallerNumber(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] < a[stack.peek()]) {
                nse[ stack.pop()]=i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            nse[stack.pop()] = a.length;
        }
        return nse;
    }

    static int[] previousSmallerOrEqualNumber(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] psoe = new int[a.length];
        for (int i = a.length-1;i>=0 ;i--) {
            while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                psoe[ stack.pop()]=i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            psoe[stack.pop()] = -1;
        }
        return psoe;
    }


    public static void main(String[] as) {
        int[] arr = {11,81,94,43,3};
        //444
        System.out.println(sumSubarrayMins(arr));
    }

}
