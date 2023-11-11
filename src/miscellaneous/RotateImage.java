package miscellaneous;

import java.util.Scanner;

public class RotateImage {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		Integer matrix[][]=new Integer[n][n];
		for(int i=0;i<n;i++) {
			String row[]=s.nextLine().split(" ");
			for(int j=0;j<n;j++) {
				matrix[i][j]=Integer.parseInt(row[j]);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=n-1;j>=0;j--) {
				System.out.print(matrix[j][i]+" ");
			}
			System.out.println();
		}

	}
}
