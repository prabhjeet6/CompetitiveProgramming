package gfg;

public class NumberOfPaths {

    static long numberOfPaths(int M, int N) {
        if (M == 1 || N == 1) {
            return 1;
        }
        return numberOfPaths(M - 1, N) + numberOfPaths(M, N - 1);
    }

    public static void main(String arg[]) {
        System.out.print(numberOfPaths(3, 3));
    }
}

//Method2
//Instead of making count the part of recursion, as an argument, use count as class variable, that way, its value will not vanish
class NumberOfPaths2 {
    static int cnt = 0;

    static long numberOfPaths(int m, int n) {
        countAllPaths(0, 0, m, n);
        return cnt;
    }

    static void countAllPaths(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            cnt++;
            return;
        }
        countAllPaths(i, j + 1, m, n);
        countAllPaths(i + 1, j, m, n);
    }
}

/***https://www.youtube.com/watch?v=sLuKQ9mZFz0*/
//2D Memoisation DP
class NumberOfPaths3 {

    long numberOfPaths(int M, int N) {
        // Code Here
        long matrix[][] = new long[M][N];
        for (int i = 0; i < M; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < N; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }
        return matrix[M - 1][N - 1];
    }
}
/*Expected Time Complexity: O(M)
Expected Space Complexity: O(1)

Constraints:
1 ≤ N ≤ 108
1 ≤ M ≤ 105*/

/***https://www.youtube.com/watch?v=o3nlpu8meIE*/
class NumberOfPathsOptimalSolution {


    static int modVal = 1000000000 + 7;

    static long numberOfPaths(int M, int N) {
        //total (N-1)+(M-1) =(M+N-2) possible moves
        //we can select either M-1 options or N-1 options, whichever is lower, see line 82
        return nCr(M + N - 2, M - 1);
    }

    // Function to calculate nCr % modVal
    static long nCr(int n, int r) {
        long res = 1;

        // If r is more than n/2, then it's equivalent to n-r
        if (r > n - r) r = n - r;

        //nCr=n!/r!(n-r)!
        //(a/b)%m=(axb^-1)%m=(a%mx(b^-1)%m)%m
        for (int i = 0; i < r; i++) {
            res = (res * (n - i)) % modVal;
            res = (res * modInverse(i + 1)) % modVal;
        }

        return res;
    }

    // Function to calculate x raised to the power y using binary exponentiation
    static long power(long x, long y) {
        //iterative Fast Exponentiation
        long res = 1;
        x = x % modVal;
        while (y > 0) {
            //bitwise & identifies if the right most bit is 1, suggesting number is odd
            if ((y & 1) == 1) {
                //after multiplying the number once, power decreases by 1 and  becomes even(line 105 and 106)
                res = (res * x) % modVal;
            }
            y = y >> 1;
            x = (x * x) % modVal;
        }
        return res;
    }

    // Function to find modular inverse of a under modulo modVal using Fermat's Little Theorem
    static long modInverse(int a) {
        //Fermax's littile theorem
        // (b^-1)%m=(b^(m-2))%m
        //where m is a prime number
        return power(a, modVal - 2);
    }
}