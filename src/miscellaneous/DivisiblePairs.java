package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * You are given an array A of N numbers, output the count of pairs in the array
 * whose sum is divisible by 4 .
 * 
 * Input Format The first line of the input contains a single integer T denoting
 * the number of test cases.
 * 
 * The description of T test cases follows.
 * 
 * The first line of each test case contains a single integer N .
 * 
 * The second line contains N space-separated integers A [ 0 ] , A [ 1 ] , . . .
 * , A [ N - 1 ] representing the array numbers.
 * 
 * Output Format For each test case, output the count of pairs in the array
 * whose sum is divisible by 4 on a separate line.
 */
public class DivisiblePairs {

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(bufferedReader.readLine());
		for(int i=0;i<T;i++) {
			int N=Integer.parseInt(bufferedReader.readLine());
			int arr[]=Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int count[]=new int[4];
			for(int j=0;j<arr.length;j++) {
				count[arr[j]%4]++;
			}
			int ans=0;
			ans+=(count[0]*(count[0]-1))/2;
			//for(i=1;i<=1;i++) {
				ans+=count[1]*count[3];
			//}
				ans+=(count[2]*(count[2]-1))/2;
				System.out.println(ans);
			
		}
		
	}

}
