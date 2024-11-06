package miscellaneous.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingPrimes {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		int Primes[] = sieveOfErostasis(1000001);
		int countPrimes[]=new int[1000001];
		countPrimes[0]=0;
		for(int i=1;i<=1000000;i++) {
			countPrimes[i]=countPrimes[i-1]+Primes[i];
		}
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			System.out.println(countPrimes[N]);
		}
	}

	private static int[] sieveOfErostasis(int N) {
		int Primes[] = new int[N + 1];
		for (int j = 1; j <= N; j++) {
			Primes[j] = 1;
		}
		Primes[1] = 0;
		for (int i = 2; i*i<=N; i++) {
			if (Primes[i] == 1) {
				for (int j = i*i; j <= N; j=j+i) {
					Primes[j] = 0;
				}
			}
		}
		return Primes;
	}
}
