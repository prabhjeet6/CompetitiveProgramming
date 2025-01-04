package gfg;

class QuickSort
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int[] arr, int low, int high)
    {
        if(low>high){
            return;
        }
        int p=partition(arr,low,high);
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
    }
    static int partition(int[] arr, int low, int high)
    {
        int pivot=low;
        int left=low+1;
        int right=high;
        while(left<=right){
            while(left<=high &&arr[left]<=arr[pivot]){
                left++;
            }
            while(right>=low &&arr[right]>arr[pivot]){
                right--;
            }
            if(left<right){
                swap(arr,left,right);
            }
        }
        swap(arr,pivot,right);
        return right;
    }
    private static void swap(int[] arr,int left,int right){

        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

    }
}
