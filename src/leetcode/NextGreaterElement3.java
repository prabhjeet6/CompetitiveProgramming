package leetcode;
//https://leetcode.com/problems/next-greater-element-iii/


class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        String input=String.valueOf(n);

        char[] inputChars=input.toCharArray();
        int length=inputChars.length;
        int pivot=-1;

        for(int i=length-1;i>0;i--){

            //123 132 213 231 312 321
            //1234 1243 1324 1342 2134 2143 2314 2341 2413
            if(inputChars[i-1]<inputChars[i]){
                pivot=i-1;
                break;
            }

        }

        if(pivot==-1){
            return pivot;
        }else{
            //2147483476 ...674
            //2147483647 ...647
            for(int i=length-1;i>0;i--){
                if(inputChars[i]>inputChars[pivot]){
                    swap(inputChars,i,pivot);
                    break;
                }
            }
            int left=pivot+1;
            int right=length-1;
            while(left<=right){
                swap(inputChars,left,right);
                left++;
                right--;
            }
            String res="";
            for(int i=0;i<length;i++){
                res+=inputChars[i];
            }
            long ans=Long.parseLong(res);
            if(ans>Integer.MAX_VALUE){
                return -1;
            }else{
                return (int)ans;
            }

        }
    }
    void swap(char a[],int i,int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
