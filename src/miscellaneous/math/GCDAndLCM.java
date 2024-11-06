package miscellaneous.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * You are given two numbers A and B .
 * 
 * Print two integers X and Y where X = G C D ( A , B ) and Y = L C M ( A , B )
 * .
 * 
 * Input Format Input consists of two space separated integers A and B .
 * 
 * Output Format Print two Integers X and Y .
 * 
 * Constraints 1 <= A , B <= 10^ 9
 */
public class GCDAndLCM {

	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String ab[]=bufferedReader.readLine().split(" ");
		long a=Long.parseLong(ab[0]);
		long b=Long.parseLong(ab[1]);
		long gcd=gcd(a,b);
		System.out.print(gcd+" ");
		System.out.print(a*b/gcd);

	}

	private static long gcd(long a, long b) {
       long max=a>b?a:b;
       long min=a<b?a:b;
		while(max%min!=0) {
			long remainder=max%min;
			max=min;
			min=remainder;
		}
		return min;
	}
}
