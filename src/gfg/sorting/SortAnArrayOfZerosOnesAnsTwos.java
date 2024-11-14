package gfg.sorting;


import java.util.Arrays;

class SortAnArrayOfZerosOnesAnsTwos {
    public static void main(String[] a) {
        //sort012(new int[]{0, 1, 2, 0, 1, 2});
        //sort012(new int[]{ 1, 0, 2});
        //sort012(new int[]{1 ,0 ,2 ,1 ,1 ,1 ,0});
        //sort012(new int[]{2, 2, 1, 1, 1, 2, 1, 2, 1});

        sort012PartitionWithCount(new int[]{0, 1, 2, 0, 1, 2});
        sort012PartitionWithCount(new int[]{ 1, 0, 2});
        sort012PartitionWithCount(new int[]{1 ,0 ,2 ,1 ,1 ,1 ,0});
        sort012PartitionWithCount(new int[]{2, 2, 1, 1, 1, 2, 1, 2, 1});



    }

    public static void sort012PartitionWithCount(int[] arr) {


    }
    // Function to sort an array of 0s, 1s, and 2s
    public static void sort012(int[] arr) {
        int left = 0, right = arr.length - 1, lastIndex = 0;
        while (left < right) {
           if(arr[left]==0){
              lastIndex=left;
              left++;
           }else if(arr[right]==0){
               swap(left,right,arr);
               lastIndex=left;
           }else{
               right--;
           }
        }

        System.out.println(Arrays.toString(arr));
        left = arr[lastIndex]==0?lastIndex + 1:lastIndex;
        right = arr.length - 1;
        while (left < right) {
            if(arr[left]==1){
                left++;
            }else if(arr[right]==1){
                swap(left,right,arr);
            }else{
                right--;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void sort012Approach2(int[] nums) {
        int zero=0,one=0,two=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)zero++;
            else if(nums[i]==1)one++;
            else two++;
        }
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=2){
                if(i!=count2){
                    swap(i, count2,nums);
                }
                count2++;
            }
        }
        int count1=0;
        for(int i=0;i<nums.length-two;i++){
            if(nums[i]!=1){
                if(i!=count1){
                    swap(i, count1,nums);
                }
                count1++;
            }
        }

        int count0=0;
        for(int i=0;i<nums.length-two-one;i++){
            if(nums[i]!=1){
                if(i!=count0){
                    swap(i, count0,nums);
                }
                count0++;
            }
        }

    }

}