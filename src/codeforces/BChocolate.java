package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BChocolate {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int nuts[] = new int[n];
		nuts = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (nuts[i] == 1)
				count++;
		}
		if (count == 0 || count == 1)
			System.out.println(count);
		else {
			/***
			 * 5
			 * 1 0 1 0 1
			 * Multiply number of zeros plus 1 between two consecutive 1s
			 * 2*2=4
			 * Explaination 
			 * https://www.youtube.com/watch?v=neQxEoX-1rE
			 */

			long result = 1, prev = -1;
			for (int i = 0; i < n; i++) {
				if (nuts[i] == 1) {
					if (prev != -1) {
						result *= (i - prev);
					}
					prev = i;
				}
			}
			System.out.println(result);
		}
	}

}