package Hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class CommonChild {

     /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
      int lcs( char[] X, char[] Y, int m, int n ) 
      { 
        int L[][] = new int[m+1][n+1]; 
      
        /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
             that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++) 
        { 
          for (int j=0; j<=n; j++) 
          { 
            if (i == 0 || j == 0) 
                L[i][j] = 0; 
            else if (X[i-1] == Y[j-1]) 
                L[i][j] = L[i-1][j-1] + 1; 
            else
                L[i][j] = max(L[i-1][j], L[i][j-1]); 
          } 
        } 
      return L[m][n]; 
      } 
     int lcs(String  X, String  Y, int m, int n) 
        { 
            if (m == 0 || n == 0) 
                return 0; 
           /* if (X[m - 1] == Y[n - 1]) 
                return 1 + lcs(X, Y, m - 1, n - 1); 
            else
                return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n)); */
            
            if (X.charAt(m-1) == Y.charAt(n-1)) 
                return 1 + lcs(X, Y, m - 1, n - 1); 
            else
                return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
            
        } 
     int max(int a, int b) 
        { 
            return (a > b) ? a : b; 
        } 
    
    static int commonChild(String s1, String s2) {
        int previousindexins2 = 0, count = 0, indexins2 = 0;
        int i = 0, k = 0, commonchild[] = new int[s1.length()];
        while (i < s1.length() && k < s1.length() && previousindexins2 < s2.length() - 1) {
            /*
             * if (previousindexins2 == 0 ?
             * s2.substring(previousindexins2).contains(((Character)
             * s1.charAt(i)).toString()) : s2.substring(previousindexins2 +
             * 1).contains(((Character) s1.charAt(i)).toString())) {
             */
            if ((previousindexins2 == 0 && s2.contains(((Character) s1.charAt(i)).toString()))
                    || (previousindexins2 != 0
                            && s2.substring(previousindexins2 + 1).contains(((Character) s1.charAt(i)).toString()))) {
                if (previousindexins2 == 0)
                    indexins2 = s2.substring(previousindexins2).indexOf(((Character) s1.charAt(i)).toString());
                else
                    indexins2 = previousindexins2
                            + s2.substring(previousindexins2 + 1).indexOf(((Character) s1.charAt(i)).toString());
                /*
                 * int indexins2 = previousindexins2 == 0 ?
                 * s2.substring(previousindexins2).indexOf(((Character)
                 * s1.charAt(i)).toString()) : previousindexins2 +
                 * s2.substring(previousindexins2 + 1).indexOf(((Character)
                 * s1.charAt(i)).toString());
                 */

                if (previousindexins2 < indexins2 || previousindexins2 == 0) {
                    count++;
                    previousindexins2 = indexins2;
                }
            }
            if (i == s1.length() - 1 && k != s1.length()) {

                commonchild[k] = count;
                k++;
                count = 0;
                i = k;
                previousindexins2 = 0;
                continue;
            }
            i++;
        }

        int max = 0;

        for (int it = 0; it < commonchild.length; it++) {
            if (max < commonchild[it])
                max = commonchild[it];
        }
        /*
         * for (int f = 0; f < s1.length(); f++) { System.out.println(commonchild[f]); }
         */
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        //int result = commonChild(s1, s2);
        //int result2 = commonChild(s2, s1);
        //System.out.println(result > result2 ? result : result2);
        System.out.println(new CommonChild().lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        scanner.close();
    }
}
