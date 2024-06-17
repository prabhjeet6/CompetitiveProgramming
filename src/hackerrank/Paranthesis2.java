package hackerrank;
import java.util.Scanner;

public class Paranthesis2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        balancedString(0, 0, 0, 0, new char[2 * (N + M)],0, N, M);
    }

    private static void balancedString(int openParan, int closeParan, int openBrace, int closeBrace, char c[],int size,int n, int m) {

        if (((openBrace + closeBrace) == 2 * m) && ((openParan + closeParan) == 2*n)) {
            String str = "";
            for (int i = 0;i<size;i++) {
                str += String.valueOf(c[i]);
            }
            System.out.println(str);
            return;
        }
// case 1
        if (openParan == closeParan && openBrace == closeBrace) {
            if (openParan == n) {
                c[size] = '{';
                balancedString(openParan, closeParan, openBrace + 1, closeBrace, c, size + 1, n, m);
            }
            else if (openBrace == m) {
                c[size] = '(';
                balancedString(openParan + 1, closeParan, openBrace, closeBrace, c, size + 1, n, m);
            } else {
                c[size] = '{';
                balancedString(openParan, closeParan, openBrace + 1, closeBrace, c, size + 1, n, m);
                c[size] = '(';
                balancedString(openParan + 1, closeParan, openBrace, closeBrace, c, size + 1, n, m);
            }
        }

//case 2
        if (openParan == closeParan && openBrace > closeBrace) {
            if (openBrace == m) {
                c[size] = '}';
                balancedString(openParan, closeParan, openBrace, closeBrace + 1, c, size + 1, n, m);
            } else {
                c[size] = '}';
                balancedString(openParan, closeParan, openBrace, closeBrace + 1, c, size + 1, n, m);
                c[size] = '{';
                balancedString(openParan, closeParan, openBrace + 1, closeBrace, c, size + 1, n, m);
            }

            if (openParan != n) {
                c[size] = '(';
                balancedString(openParan + 1, closeParan, openBrace, closeBrace, c, size + 1, n, m);
            }
        }

//case 3
        if (openParan > closeParan && openBrace == closeBrace) {
            if (openParan == n) {
                c[size] = ')';
                balancedString(openParan, closeParan + 1, openBrace, closeBrace, c, size + 1, n, m);
            } else {
                c[size] = ')';
                balancedString(openParan, closeParan + 1, openBrace, closeBrace, c, size + 1, n, m);
                c[size] = '(';
                balancedString(openParan + 1, closeParan, openBrace, closeBrace, c, size + 1, n, m);
            }

            if (openBrace != m) {
                c[size] = '{';
                balancedString(openParan, closeParan, openBrace + 1, closeBrace, c, size + 1, n, m);
            }
        }

//case 4
        if (openParan > closeParan && openBrace > closeBrace) {

            int OP = 0, CP = 0, OB = 0, CB = 0;
            for (int i = size - 1; i >= 0;i--) {
                if (OP > CP || OB > CB) {
                    break;
                }
                if ("(".equals(String.valueOf(c[i])))
                    OP++;
                else if (")".equals(String.valueOf(c[i])))
                    CP++;
                else if ("{".equals(String.valueOf(c[i])))
                    OB++;
                else if ("}".equals(String.valueOf(c[i])))
                    CB++;
            }

            if (OP > CP) {
                c[size] = ')';
                balancedString(openParan, closeParan + 1, openBrace, closeBrace, c, size + 1, n, m);
            } else {
                c[size] = '}';
                balancedString(openParan, closeParan, openBrace, closeBrace + 1, c, size + 1, n, m);
            }

            if (openParan != n) {
                c[size] = '(';
                balancedString(openParan + 1, closeParan, openBrace, closeBrace, c, size + 1, n, m);
            }

            if (openBrace != m) {
                c[size] = '{';
                balancedString(openParan, closeParan, openBrace + 1, closeBrace, c, size + 1, n, m);
            }
        }

    }

}