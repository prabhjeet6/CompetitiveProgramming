package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int input=Integer.parseInt(bufferedReader.readLine());
        int max=Integer.MIN_VALUE;
        //12345
        while(input>0){
            int remainder=input%10;
            if(max<remainder){
                max=remainder;
            }
            input/=10;
        }
        System.out.println(max);
    }

}
