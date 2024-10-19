package miscellaneous;

import java.util.*;
import java.lang.*;
import java.io.*;

public class First1inArray
{
    public static void main (String[] args) throws java.lang.Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine().trim());
        int[]nums =Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index=binarySearch(nums, 1);
        if(index==-1){
            System.out.println(index);
        }else{
            int start=index;
            //i may become -1, hence, use i>=0 condition with shortcut AND
            for(int i=start;i>=0&&nums[i]==1;i--){
                start=i;
            }
            System.out.println(start+1);
        }
    }
    static int binarySearch(int[]nums,int target){
        int left=0,right=nums.length-1, mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}
