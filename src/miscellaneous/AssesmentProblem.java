package miscellaneous;/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class AssesmentProblem
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine().trim());

        for(int i=1;i<=t;i++){
            //a1 a2 a3 a4 a5
            // 1 10 19 28 37..
            long leaps=0,distance=0,leapDistance=1;
            long n= Long.parseLong(bf.readLine().trim());
            while(distance<n){
                distance+=leapDistance;
                leapDistance+=9;
                leaps++;

            }
            System.out.println("Case #"+i+": "+leaps);
        }
    }
}