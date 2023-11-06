package hackerrank;

import java.util.Scanner;

 class Solution12 {

    // Complete the staircase function below.
    static void staircase(int n) {
         int counter=n;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
       if(counter>i)
        System.out.print(" ");
       else  
          System.out.print("#");
           counter--; 
        }
        counter=n;
        System.out.println();
    }
}


   private  static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
