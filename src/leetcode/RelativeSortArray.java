package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class RelativeSortArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //sort arr1 such that relative ordering of items in arr1 is same as in arr2. Elements that do
        // not appear in arr2 should be placed in arr1 in ascending order
       // System.out.println(Arrays.toString(relativeSortArray1(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArray2(arr1, arr2)));
    }
    //TC:O(mn+n log n) SC:O(n)
    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int counter = 0;
        for (int num : arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == num) {
                    result[counter] = num;
                    counter++;
                    arr1[i] = -1;
                }
            }
        }
        Arrays.sort(arr1);
        int index = binarySearch(arr1);
        if (index != -1) {
            for (int i = index; i < arr1.length; i++) {
                result[i] = arr1[i];
            }
        }
        return result;
    }
    static int binarySearch(int[] arr1) {
        int low = 0, high = arr1.length - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr1[mid] == -1) {
                low = mid + 1;
            } else if (arr1[mid] >= 0) {
                if (arr1[mid - 1] == -1) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer,Integer> frequency=new HashMap<>();
        for(int num:arr2){
            frequency.put(num,0);
        }
        int[] remaining=new int[arr1.length-arr2.length];
        Arrays.fill(remaining,-1);
        int counter=0;
        for(int num:arr1){
            if(frequency.containsKey(num)){
                frequency.put(num,frequency.getOrDefault(num,0)+1);
            }else{
                remaining[counter++]=num;
            }
        }
        Arrays.sort(remaining);
        int[]result=new int[arr1.length];
        counter=0;
        for(int i=0;i<arr2.length;i++){
            int freq=frequency.get(arr2[i]);
            while(freq>0){
                freq--;
                result[counter++]=arr2[i];
            }
        }
        counter=0;
        for(int i=arr2.length;i<arr1.length;i++){
            if(remaining[counter]!=-1) {
                result[i] = remaining[counter];
            }
            counter++;
        }
        return result;
    }


}