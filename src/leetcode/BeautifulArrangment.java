package leetcode;


class BeautifulArrangment {

    int count;

    int [] createArray(int n){
        int permutation[]=new int[n+1];
        for(int i=1;i<=n;i++){
            permutation[i]=i;
        }
        return permutation;
    }
    public int countArrangement(int n) {
        backtrack(n, createArray(n),1);
        return count;

    }
    void backtrack(int n,int[] permutation,int idx){
        if(idx==n){
            /*boolean isBeautiful=true;
            for(int j=1;j<=n;j++){
                if(!(j%permutation[j]==0||permutation[j]%j==0)){
                        isBeautiful=false;
                }
            }
            if(isBeautiful){*/
            count++;
            //}
            return;
        }
        for(int i=idx;i<=n;i++){

            swap(permutation, idx,i);
            if (permutation[idx] % (idx + 1) == 0 || (idx + 1) % permutation[idx] == 0){
                backtrack( n, permutation, idx+1);
            }
            swap(permutation, idx,i);


        }
    }
    void swap(int [] permutation, int idx,int i){
        int temp=permutation[i];
        permutation[i]=permutation[idx];
        permutation[idx]=temp;
    }
}