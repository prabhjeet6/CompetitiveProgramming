package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<T;i++){
            int N= Integer.parseInt(bufferedReader.readLine());
            int arr[]= Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            findLengthOfLongestSubArray(arr);
        }
    }
    private static void findLengthOfLongestSubArray(int[] arr) {
        int prefixSum[]=new int[arr.length];
        prefixSum[0]=arr[0];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            prefixSum[i]+=arr[i]+prefixSum[i-1];
        }
        Map<Integer,Integer> map=new HashMap<>();
        //Adding entry for empty prefix
        /*
        Example:
        arr:   1 2 2 -5
  PrefixSum: 0  1 3 5  0
  index:    -1  0 1 2  3
  * */
        map.put(0,-1);
        for(int i=0;i<arr.length;i++) {
            map.putIfAbsent(prefixSum[i],i);
        }
        for(int i=0;i<arr.length;i++) {
            if(i-map.get(prefixSum[i])>ans){
                ans=i-map.get(prefixSum[i]);
            }
        }
        System.out.println(ans);
    }
}
