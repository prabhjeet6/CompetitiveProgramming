package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Bob and Alice are participating in a contest. There are N problems in this
 * contest; each problem has a unique problem code between 1 and N inclusive.
 * Bob and Alice decided to split the problems to solve between them Bob should
 * solve the problems whose problem codes are divisible by A but not divisible
 * by B , and Alice should solve the problems whose problem codes are divisible
 * by B but not divisible by A (they decided to not solve the problems whose
 * codes are divisible by both A and B ).
 * 
 * To win, it is necessary to solve at least K problems. You have to tell Bob
 * whether they are going to win or lose.
 * 
 * Input Format
 * 
 * The first line of the input contains a single integer T denoting the number
 * of test cases. The description of T test cases follows. The first and only
 * line of each test case contains four space-separated integers N , A , B and K
 */
public class SpecialContest {
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < T; i++) {
			String NABK[] = bufferedReader.readLine().split(" ");
			long N = Long.parseLong(NABK[0]);
			long A = Long.parseLong(NABK[1]);
			long B = Long.parseLong(NABK[2]);
			long K = Long.parseLong(NABK[3]);

			long lcm = (A * B) / gcd(A, B);
			if (N / A + N / B - 2 * (N / lcm) >= K) {
				System.out.println("Win");
			} else {
				System.out.println("Lose");
			}

		}
	}

	private static long gcd(long a, long b) {
		long max = a > b ? a : b;
		long min = a < b ? a : b;
		while (max % min != 0) {
			long remainder = max % min;
			max = min;
			min = remainder;
		}
		return min;
	}

}
