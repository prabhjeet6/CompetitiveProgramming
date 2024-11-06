package gfg.sorting;

public class BubbleSort {
    public static void bubbleSort(int a[], int n)
    {
        boolean done=false;
        while(!done){
            done=true;
            int i=0;
            while(i<n-1){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    done=false;
                }i++;
            }
        }
    }
    public static void main(String asd[]){

    }
}
