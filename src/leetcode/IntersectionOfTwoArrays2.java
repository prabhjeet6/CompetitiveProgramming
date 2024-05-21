package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class IntersectionOfTwoArrays2 {
    public static void main(String as[]){
        int nums1[]={1,2,2,1};
        int nums2[]={2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int ptr1=0,ptr2=0;
        List<Integer>result=new ArrayList<Integer>();

        //Arrays.sort(nums1);
        //Arrays.sort(nums2);
        while(ptr1<nums1.length&&ptr2<nums2.length){
            if(nums1[ptr1]!=nums2[ptr2]&&ptr2!=nums2.length-1){
                ptr2++;

            }
            if(nums1[ptr1]!=nums2[ptr2]&&ptr2==nums2.length-1){
                ptr1++;
                ptr2=0;
            }
            if(nums1[ptr1]==nums2[ptr2]){
                result.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
        }
        int [] ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;


    }
    public int[] intersectBruteForce(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();
        boolean visited[] = new boolean[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !visited[j]) {
                    visited[j] = true;
                    ls.add(nums1[i]);
                    break;
                }
            }
        }
        int result[] = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            result[i] = ls.get(i);

        }
        return result;
    }


}
