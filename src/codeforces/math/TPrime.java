package codeforces.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/*** https://codeforces.com/problemset/problem/230/B */

/***
 * It can be shown that only squares of prime numbers are T-primes, and that
 * there are not too many of them � as many as there are prime numbers not
 * greater than . Precompute these numbers (using, for example, the sieve of
 * Eratosthenes) and store them in an array or an std::set, then we can answer
 * each query by simply checking whether the number in question is amongst the
 * precomputed numbers.
 * 
 * The complexity of the solution is linear in relation to n � or , where d =
 * 1012 (one can also get a tighter bound)
 */
public class TPrime {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		long[] arr = Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long Primes[] = sieveOfErostasis(1000001);
        optimizedApproach(arr, Primes);
		//bruteForce(N, arr);
	}
	static void optimizedApproach(long arr[],long []Primes) {
		for (int i = 0; i < arr.length; i++) {
			// Only Squares of Prime numbers are T primes
			long sqrt = (long) Math.sqrt(arr[i]);
			if (sqrt * sqrt != arr[i]) {
				// arr[i] will have even number of factors as it is a perfect square
				System.out.println("NO");
				continue;
			} else {
				if (Primes[(int) sqrt] == 1) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	static void bruteForce(int N, long arr[]) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			long sqrt = (int) Math.sqrt(arr[i]);
			if (sqrt * sqrt != arr[i]) {
				// arr[i] will have even number of factors as it is a perfect square
				System.out.println("NO");
				continue;
			}
			for (int j = 2; j <= sqrt; j++) {
				if (arr[i] % j == 0) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			count = 0;
		}
	}

	private static long[] sieveOfErostasis(int N) {
		long Primes[] = new long[N + 1];
		for (int j = 1; j <= N; j++) {
			Primes[j] = 1;
		}
		Primes[1] = 0;
		for (int i = 2; i * i <= N; i++) {
			if (Primes[i] == 1) {
				for (int j = i * i; j <= N; j += i) {
					Primes[j] = 0;
				}
			}
		}
		return Primes;
	}
}
