package hackerrank;

import java.util.Scanner;

 class Solution10 {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr,int n) {
        int negative=0,positive=0,zero=0;
    for(int i:arr){
        if(i<0)
         negative++;
         else if(i>0)
             positive++;
             else zero++; 
    }
         System.out.println((double)positive/n);
          System.out.println((double)negative/n);
           System.out.println((double)zero/n);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr,n);

        scanner.close();
    }
}
