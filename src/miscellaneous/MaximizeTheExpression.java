package miscellaneous;

import java.util.Scanner;

/***
 * Compute maximum possible value for expression s=p*arr[i]+q*arr[j]+r*arr[k]
 * where i<j<k
 * 
 * TimeComplexity O(N)
 * Space ComplexityO(N)
 * Technique: Precomputation
 */
class MaximizeTheExpression {
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
			for (int i = 1; i <= numberOfElementsInArray - 2; i++) {
				long expr = prefixMax[i - 1] + q * ar[i] + suffixMax[i + 1];
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
