package NumberOfPaths;

public class NumberOfPaths {
	/*
	 * Needs Memoization technique from DP. memoization is an optimization technique
	 * that makes applications more efficient and hence faster. It does this by
	 * storing computation results in cache, and retrieving that same information
	 * from the cache the next time it's needed instead of computing it again
	 */
	static long numberOfPaths(long M, long N) {
		if (1 == M || 1 == N)
			return 1 % 1000000007;
		// Bottom up approach
		// Solution has Time Complexity O(2^(m+n)), hence, stackoverflow error
		// Using Memoization, this can be solved in linear time.
		return (numberOfPaths(M - 1, N) % 1000000007 + numberOfPaths(M, N - 1) % 1000000007) % 1000000007;
	}

	public static void main(String args[]) {
		System.out.println(numberOfPaths(10, 100000000) % 1000000007);
	}

}
