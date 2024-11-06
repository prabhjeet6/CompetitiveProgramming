package codeforces.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://codeforces.com/problemset/problem/621/B
 * 
 * Let's start with two bishops (x1, y1) and (x2, y2). Notice that if (x1, y1)
 * attacks (x2, y2), either x1 + y1 == x2 + y2 OR x1 � y1 == x2 � y2. So, for
 * each bishop (x, y), we will store x + y in one map and x � y in another map.
 */
public class WetSharkAndBishops {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		long leftDiag[] = new long[2001];
		long rightDiag[] = new long[2001];
		for (int i = 0; i < n; i++) {
			String xy[] = bufferedReader.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			// count all left diagonals
			leftDiag[x + y]++;
			// count all right diagonals
			//x-y could be negative adding total grids divides the number uniformly
			rightDiag[1000 + (x - y)]++;
		}

		long ans = 0;
		for (int i = 0; i < 2001; i++) {
			if (leftDiag[i] >= 2) { // if there are atleast 2 bishops in any diagonal, they can attack each other,
									// choose total number of combinations of 2 bishops amongst total bishops on the
									// diagonal
				long x = leftDiag[i];
				ans += (x * (x - 1)) / 2; // xC2
			}

			if (rightDiag[i] >= 2) {
				long x = rightDiag[i];
				ans += (x * (x - 1)) / 2;
			}
		}
		System.out.println(ans);
	}
}
