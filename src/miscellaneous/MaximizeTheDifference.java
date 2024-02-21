package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
public class MaximizeTheDifference {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<T;i++){
            String[] NAndK=bufferedReader.readLine().split(" ");
            int N=Integer.parseInt(NAndK[0]);
            int K=Integer.parseInt(NAndK[1]);
            long weights[]= Stream.of(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(weights);
            int lightWeightCount=0,weightForChild=0,weightForFather=0;
            for(int j=0;j<weights.length;j++){
               if(K<N-K) {
                   if (lightWeightCount < K) {
                       weightForChild += weights[j];
                       lightWeightCount++;
                   } else {
                       weightForFather += weights[j];
                   }
               }else{
                   if (lightWeightCount < N-K) {
                       weightForChild += weights[j];
                       lightWeightCount++;
                   } else {
                       weightForFather += weights[j];
                   }
               }
            }
            System.out.println(weightForFather-weightForChild);

        }
    }

}
