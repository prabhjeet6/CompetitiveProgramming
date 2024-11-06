package codeforces.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * C. Star sky time limit per test2 seconds memory limit per test256 megabytes
 * inputstandard input outputstandard output The Cartesian coordinate system is
 * set in the sky. There you can see n stars, the i-th has coordinates (xi, yi),
 * a maximum brightness c, equal for all stars, and an initial brightness si (0
 * <= si <= c).
 * 
 * Over time the stars twinkle. At moment 0 the i-th star has brightness si. Let
 * at moment t some star has brightness x. Then at moment (t + 1) this star will
 * have brightness x + 1, if x + 1 <= c, and 0, otherwise.
 * 
 * You want to look at the sky q times. In the i-th time you will look at the
 * moment ti and you will see a rectangle with sides parallel to the coordinate
 * axes, the lower left corner has coordinates (x1i, y1i) and the upper right �
 * (x2i, y2i). For each view, you want to know the total brightness of the stars
 * lying in the viewed rectangle.
 * 
 * A star lies in a rectangle if it lies on its border or lies strictly inside
 * it.
 * 
 * Input The first line contains three integers n, q, c (1 <= n, q <= 105, 1 <=
 * c <= 10) � the number of the stars, the number of the views and the maximum
 * brightness of the stars.
 * 
 * The next n lines contain the stars description. The i-th from these lines
 * contains three integers xi, yi, si (1 <= xi, yi <= 100, 0 <= si <= c <= 10) �
 * the coordinates of i-th star and its initial brightness.
 * 
 * The next q lines contain the views description. The i-th from these lines
 * contains five integers ti, x1i, y1i, x2i, y2i (0 <= ti <= 109, 1 <= x1i < x2i
 * <= 100, 1 <= y1i < y2i <= 100) � the moment of the i-th view and the
 * coordinates of the viewed rectangle.
 * 
 * Output For each view print the total brightness of the viewed stars.
 * 
 * 2 3 3 1 1 1 3 2 0 2 1 1 2 2 0 2 1 4 5 5 1 1 5 5 Output: 3 0 3
 * 
 * Input: 3 4 5 1 1 2 2 3 0 3 3 1 0 1 1 100 100 1 2 2 4 4 2 2 1 4 7 1 50 50 51
 * 51
 * 
 * Output: 3 3 5 0
 * 
 */
public class StarSkyBruteForce {

	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String nqc[] = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(nqc[0]);
		int q = Integer.parseInt(nqc[1]);
		int c = Integer.parseInt(nqc[2]);
		Integer coordinates[][] = new Integer[n][n];
		Integer brightness[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			String xyc[] = bufferedReader.readLine().split(" ");
			coordinates[i][0] = Integer.parseInt(xyc[0]);
			coordinates[i][1] = Integer.parseInt(xyc[1]);
			brightness[i] = Integer.parseInt(xyc[2]);
		}
		for (int i = 0; i < q; i++) {
			String tx1y1x2y2[] = bufferedReader.readLine().split(" ");
			// ti, x1i, y1i, x2i, y2i
			int t = Integer.parseInt(tx1y1x2y2[0]);
			int x1 = Integer.parseInt(tx1y1x2y2[1]);
			int y1 = Integer.parseInt(tx1y1x2y2[2]);
			int x2 = Integer.parseInt(tx1y1x2y2[3]);
			int y2 = Integer.parseInt(tx1y1x2y2[4]);
			calcTotalBrightnessOfVisibleStars(t, x1, y1, x2, y2, n, c, coordinates, brightness);
		}
	}

	private static void calcTotalBrightnessOfVisibleStars(int t, int x1, int y1, int x2, int y2, int n, int c,
			Integer[][] coordinates, Integer[] brightness) {
		int totalBrightness = 0;
		for (int i = 0; i < n; i++) {
			if (x1 <= coordinates[i][0] && x2 >= coordinates[i][0] && y1 <= coordinates[i][1]
					&& y2 >= coordinates[i][1]) {
				if (t > c)
					totalBrightness += (t + brightness[i]) % (c+1);
				else
					totalBrightness += (t + brightness[i]);
			}
		}
		System.out.println(totalBrightness);
	}
}
