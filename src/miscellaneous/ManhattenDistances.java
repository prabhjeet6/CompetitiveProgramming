package miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ManhattenDistances {
    public static void main(String asf[]) throws Exception{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());
        Integer xCoordinates[]=new Integer[N];
        Integer yCoordinates[]=new Integer[N];
        for(int i=0;i<N;i++){
            String ithCoordinates[]=bufferedReader.readLine().split(" ");
            xCoordinates[i]=Integer.parseInt(ithCoordinates[0]);
            yCoordinates[i]=Integer.parseInt(ithCoordinates[1]);
        }
        //manhattanDistancesSumBruteForce(N,xCoordinates,yCoordinates);
        manhattanDistancesSum(N,xCoordinates,yCoordinates);
    }
  static  void  manhattanDistancesSumBruteForce(int N,Integer[] xCoordinates,Integer[] yCoordinates){
       long manhattanDistanceSum=0l;
       //Manhattan Distance between two points (x1, y1) and (x2, y2) is:
       //|x1 – x2| + |y1 – y2|
       for(int i=0;i<N;i++) {
           for (int j = i+1; j < N; j++) {
               if(i!=j)
                   manhattanDistanceSum += Math.abs(xCoordinates[i] - xCoordinates[j]) + Math.abs(yCoordinates[i] - yCoordinates[j]);
           }
       }
       System.out.println(manhattanDistanceSum%1000000007);
    }
    /**https://www.geeksforgeeks.org/sum-manhattan-distances-pairs-points/*/
    //Manhattan Distance between two points (x1, y1) and (x2, y2) is:
    //|x1 – x2| + |y1 – y2|
    static void manhattanDistancesSum(int N,Integer[] xCoordinates,Integer[] yCoordinates){
        System.out.println((individualCoordinateSum(N,xCoordinates)+individualCoordinateSum(N,yCoordinates))%1000000007);
    }

    private static Long individualCoordinateSum(int N, Integer[] coordinates) {
        //res = res + (xi – x0) + (xi – x1) + (xi – x2) + (xi – x3)………(xi – xi-1)
        Arrays.sort(coordinates);
        long res=0l,sum=0l;
        for(int i=0;i<N;i++){
         res+=i*coordinates[i]-sum;
         sum+=coordinates[i];
        }
        return res;
    }


}
