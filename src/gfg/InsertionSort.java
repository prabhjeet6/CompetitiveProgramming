package gfg;

public class InsertionSort {
    static void insert(int arr[],int i)
    {
        arr[i]=arr[i-1];
    }
    //Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n)
    {
        for(int i=1;i<n;i++){
            int j=i;
            while(j>0&&arr[j]<arr[j-1]){
                int temp=arr[j];
                insert(arr,j);
                arr[j-1]=temp;
                j--;
            }
        }
    }

}
