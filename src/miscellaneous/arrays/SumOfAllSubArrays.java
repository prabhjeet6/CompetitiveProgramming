package miscellaneous.arrays;

import java.util.Scanner;

/***
 * Given an array arr[] with n elements , you need to find the sum all sub
 * arrays of array arr. Since the sum could be very large print the sum modulo
 * 10 9 + 7 .
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 3 1 2 3
 * 
 * Output:
 * 
 * 20
 * 
 * Explanation:
 * 
 * All subarrays are [1], [2], [3],[1,2], [2,3], [1,2,3]. Thus total sum is 20.
 * 
 * Example Input 3 1 2 3 Output 20
 */
public class SumOfAllSubArrays {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		// s.useDelimiter("[\\s,]+");
		s.useDelimiter("[\\s]*");
		int m=1000000007;
		int n = s.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextLong();
		}
		long sum=0;
		for(int i=0;i<n;i++) {
			
			//(a+b)%m=(a%m+b%m)%m
			//(a*b)%m=(a%m*b%m)%m
			long a=arr[i];
			long b=n-i;
			long c=i+1;
			long ithcontribution=((a%m*b%m)%m*c%m)%m;
			sum=(sum%m+ithcontribution%m)%m;
		}
		System.out.println(sum);
	}
}
