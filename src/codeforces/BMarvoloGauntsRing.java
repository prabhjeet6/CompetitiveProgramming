package codeforces;

import java.util.Scanner;

/***
 * https://codeforces.com/problemset/problem/855/B
 * 
 * 
 * B. Marvolo Gaunt's Ring
 * 
 * Value of x is calculated as maximum of p·ai + q·aj + r·ak for given p, q, r
 * and array a1, a2, ... an such that 1 <= i <= j <= k <= n. Help Snape find the
 * value of x. Do note that the value of x may be negative.
 * 
 * Input First line of input contains 4 integers n, p, q, r ( - 10^9 <= p, q, r <=
 * 10^9, 1 <= n <= 10^5).
 * 
 * Next line of input contains n space separated integers a1, a2, ... an ( - 10^9
 * <= ai <= 10^9).
 * 
 * Output Output a single integer the maximum value of p·ai + q·aj + r·ak that
 * can be obtained provided 1 <= i <= j <= k <= n.
 */
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int numberOfElementsInArray=s.nextInt();
        int p=s.nextInt();
        int q=s.nextInt();
        int r=s.nextInt();
        
        long[] ar = new long[numberOfElementsInArray];

		String[] arItems = s.nextLine().split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < numberOfElementsInArray; i++) {
			long arItem = Long.parseLong(arItems[i]);
			ar[i] = arItem;
		}
		long prefixMax[]=new long[numberOfElementsInArray];
        long suffixMax[]=new long[numberOfElementsInArray];
        prefixMax[0]=ar[0];
        
        for(int i=1;i<numberOfElementsInArray;i++){
            prefixMax[i]=ar[i]>prefixMax[i-1]?ar[i]:prefixMax[i-1];
        }
        suffixMax[numberOfElementsInArray-1]=ar[numberOfElementsInArray-1];
        for(int i=numberOfElementsInArray-2;i>=0;i--){
            suffixMax[i]=ar[i]>suffixMax[i+1]?ar[i]:suffixMax[i+1];
        }
        for(int i=0;i<numberOfElementsInArray;i++){
            
        }
        
        
    }
}
