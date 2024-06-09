package leetcode;


class ChildWhoHasBallAfterKSeconds {
    public int numberOfChild(int n, int k) {
        int pos=0,count=0,flag=0;

        while(count<k){
            count++;
            if(flag==0){
                pos++;
            }
            if(flag==1){
                pos--;
            }
            if(pos==n-1){
                flag=1;
                continue;
            }
            if(pos==0){
                flag=0;
                continue;
            }

        }
        return pos;
    }
}