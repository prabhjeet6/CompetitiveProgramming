package Hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 class Solution13 {

   
    static String timeConversion(String s) 
    {
       String AMORPM=s.substring(s.length()-2,s.length());

       if("AM".equals(AMORPM))
       {
           if(!s.substring(0,2).equals("12"))
              return s.substring(0,s.length()-2);
           
           else  if(s.substring(0,2).equals("12"))
              return "00"+s.substring(2,s.length()-2);
       }
       else 
       {
            if(!s.substring(0,2).equals("12"))
             {
               Integer changed=(Integer.parseInt(s.substring(0,2))+12);
               String Changedhrs=changed.toString();
               return Changedhrs+s.substring(2,s.length()-2);
             }
           else
           return s.substring(0,2)+s.substring(2,s.length()-2);  
        }
    return null;
       
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
