package miscellaneous.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**https://dmoj.ca/problem/gcj18qrb*/
public class TroubleSort {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader((System.in)));
        int T=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(bufferedReader.readLine());
            long values[]= Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            values=troubleSortEquivalent(values);
            boolean sorted=true;
            int faultyIndex=-1;
            for(int j=0;j<values.length;j++){
                if(j<values.length-1&&values[j+1]<values[j]){
                    sorted=false;
                    faultyIndex=j;
                    break;
                }
            }
            if(sorted){
                System.out.println("Case #"+(i+1)+": OK");
            }else{
                System.out.println("Case #"+(i+1)+": "+faultyIndex);
            }

        }
    }
//Trouble sort sorts odd indices and even indices individually rather than sorting the complete array
    private static long[] troubleSortEquivalent(long[] values) {
        List<Long> temp1=new ArrayList<>();
        List<Long> temp2=new ArrayList<>();
        for(int i=0;i<values.length;i++){
            if(i%2==0){
                temp1.add(values[i]);
            }else{
                temp2.add(values[i]);
            }
        }
        Collections.sort(temp1);
        Collections.sort(temp2);
        int idx1=0,idx2=0;
        for(int i=0;i<values.length;i++){
            if(i%2==0){
                values[i]=temp1.get(idx1);
                idx1++;
            }else{
                values[i]=temp2.get(idx2);
                idx2++;
            }
        }
        return values;
    }

    private static long[] troubleSort(long values[]) {
        boolean done = false;
        while (!done) {
            done = true;
            for(int  i=0;i < values.length - 2;i++){
            if (values[i] > values[i + 2]) {
                done = false;
                long  temp=values[i];
                values[i]=values[i+2];
                values[i+2]=temp;
            }
        }
    }
        return values;
}
}
