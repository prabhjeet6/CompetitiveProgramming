package gfg;
//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class NextGreaterElement {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            long[] res = new Solution().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] ngeArr = new long[arr.length];
        Stack<Integer> stack = new Stack<Integer>();

        //Input: arr[] = [1 3 2 4], n = 4
        //Output: 3 4 4 -1
        for(int i=0;i<n;i++){
                //stack is not empty and arr[i] is greater than arr[stack top]
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()])
                //store arr[i] at stack top index of nge and pop stack top.
                ngeArr[stack.pop()] = arr[i];
            //push index i to stack top
            stack.push(i);
        }

        while(!stack.isEmpty())
            //if stack is not empty even after traversing the array, pop the indices and place -1 in ngeArr[stack.pop()]
            ngeArr[stack.pop()] = -1;


        return ngeArr;
    }
}

