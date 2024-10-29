package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SmallestDivisorWithSumLessThanThreshold {
    public static void main(String[] a) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int threshold = Integer.parseInt(bufferedReader.readLine());
        bruteForce(nums, threshold);
        //the max amongst array elements will provide minimum division values,if it is a positive number
        //(according to question)
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        usingBinarySearch(nums, threshold,max);
    }

    static void bruteForce(int[] nums, int threshold) {
        boolean loop = true;
        long divisor = 1, sum = 0;
        while (loop) {
            for (int num : nums) {
                int signVal = num > 0 ? 1 : -1;
                int remainder = num % divisor != 0 ? signVal : 0;
                sum += num < divisor ? 1 : ((num / divisor) + remainder);
            }
            if (sum > threshold) {
                sum = 0;
                divisor++;
            } else {
                loop = false;
            }
        }
        System.out.println(divisor);
    }

    static void usingBinarySearch(int[] nums, int threshold,int max) {
        int left=1,right=max,mid=0;
        while (left<=right){
            //prevents overflow
            mid=left+(right-left)/2;
            boolean isFeasible=isFeasible(mid,nums,threshold);
            if(isFeasible){
                isFeasible=isFeasible(mid-1,nums,threshold);
                if(!isFeasible){
                    System.out.println(mid);
                    return;
                }else{
                    right=mid-1;
                }
            }else {
                left=mid+1;
            }
        }
    }
    private static boolean isFeasible(int mid,int[] nums, int threshold){
        int sum=0;

        for(int num:nums){
            int signVal = num > 0 ? 1 : -1;
            int remainder = num % mid != 0 ? signVal : 0;
            sum += num < mid ? 1 : ((num / mid) + remainder);
        }
        return sum<=threshold;
    }

}
