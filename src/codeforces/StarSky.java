package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarSky {

	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String nqc[] = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(nqc[0]);
		int q = Integer.parseInt(nqc[1]);
		int c = Integer.parseInt(nqc[2]);

		/*
		 * cnt is an array that contains initial brightness of n stars and their x,y
		 * coordinates. 1<=x<=100 and 0<=c<=10, while x,y column bounds range from 0 to
		 * 100 (total length 101), coordinates range from 1 to 100 as per problem
		 * statement
		 */
		int cnt[][][] = new int[c + 1][101][101];
		for (int i = 0; i < n; i++) {
			String xys[] = bufferedReader.readLine().split(" ");
			/*
			 * Taking input of n stars consisting of their x,y coordinates and initial
			 * brightness
			 */
			int x = Integer.parseInt(xys[0]);
			int y = Integer.parseInt(xys[1]);
			int s = Integer.parseInt(xys[2]);
			/*
			 * Using Hashing Technique, instead of storing coordinates and their initial
			 * brightness in any data structure, we initialize indices (s,x,y) in cnt array
			 * to 1 and rest indices remain 0.Hence we get a prepared matrix, where cells on
			 * x-y plane range from 1 to 100, and each cell has a value assigned to it
			 */
			cnt[s][x][y]++;
		}

		// Precomputation
		for (int p = 0; p <= c; p++) {
			for (int i = 1; i <= 100; i++) {
				for (int j = 1; j <= 100; j++) {
					cnt[p][i][j] += cnt[p][i - 1][j] + cnt[p][i][j - 1] - cnt[p][i - 1][j - 1];
				}
			}
		}
		
		for (int i = 0; i < q; i++) {
			String tx1y1x2y2[] = bufferedReader.readLine().split(" ");
			int t = Integer.parseInt(tx1y1x2y2[0]);
			int x1 = Integer.parseInt(tx1y1x2y2[1]);
			int y1 = Integer.parseInt(tx1y1x2y2[2]);
			int x2 = Integer.parseInt(tx1y1x2y2[3]);
			int y2 = Integer.parseInt(tx1y1x2y2[4]);
			calcSubMatrixSum(t, c, cnt, x1, y1, x2, y2);

		}

	}

	/*
	 * calculate sum of sub-matrix formed by top right and bottom left given in the
	 * input, which will give you the number of stars ,
	 * multiply with brightness as per time, given below
	 */
	private static void calcSubMatrixSum(int t, int c, int cnt[][][], int x1, int y1, int x2, int y2) {
		int res = 0;
		for (int i = 0; i <= c; i++) {
			int brightness = (i + t) % (c + 1);
			int amount = cnt[i][x2][y2] - cnt[i][x1 - 1][y2] - cnt[i][x2][y1 - 1] + cnt[i][x1 - 1][y1 - 1];
			res += amount * brightness;
		}
		System.out.println(res);

	}
}
