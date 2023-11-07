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
 * 
 * TimeComplexity O(N)
 * Space ComplexityO(N)
 * Technique: Precomputation
 */

class BMarvoloGauntsRing {
	public static void main(String args[]) {
		try (Scanner s = new Scanner(System.in)) {
			String[] inputParameters = s.nextLine().split(" ");
			int numberOfElementsInArray = Integer.parseInt(inputParameters[0]);
			int p = Integer.parseInt(inputParameters[1]);
			int q = Integer.parseInt(inputParameters[2]);
			int r = Integer.parseInt(inputParameters[3]);

			long[] ar = new long[numberOfElementsInArray];

			String[] arItems = s.nextLine().split(" ");

			for (int i = 0; i < numberOfElementsInArray; i++) {
				long arItem = Long.parseLong(arItems[i]);
				//long arItem = s.nextLong();
				ar[i] = arItem;
			}
			long prefixMax[] = new long[numberOfElementsInArray];
			long suffixMax[] = new long[numberOfElementsInArray];
			prefixMax[0] = p * ar[0];

			for (int i = 1; i < numberOfElementsInArray; i++) {
				prefixMax[i] = p * ar[i] > prefixMax[i - 1] ? p * ar[i] : prefixMax[i - 1];
			}
			suffixMax[numberOfElementsInArray - 1] = r * ar[numberOfElementsInArray - 1];
			for (int i = numberOfElementsInArray - 2; i >= 0; i--) {
				suffixMax[i] = r * ar[i] > suffixMax[i + 1] ? r * ar[i] : suffixMax[i + 1];
			}
			long max = (long) Math.pow(-2, 63);
			for (int i = 0; i <= numberOfElementsInArray - 1; i++) {
				long expr = prefixMax[i ] + q * ar[i] + suffixMax[i ];
				if (max < expr) {
					max = expr;
				}
			}
			System.out.println(max);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
