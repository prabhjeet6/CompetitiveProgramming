package leetcode;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String args[]){
        int[] happiness={12,1,42};
        System.out.println(maximumHappinessSum(happiness,3));
    }
    public long maximumHappinessSumButeForce(int[] happiness, int k) {
        int max=Integer.MIN_VALUE,maxIndex=0;
        long ans=0l;
        while(k>0){
            for(int i=0;i<happiness.length;i++){
                if(max<happiness[i]){
                    max=happiness[i];
                    maxIndex=i;
                }
            }
            happiness[maxIndex]=0;
            maxIndex=0;
            ans+=max;
            max=Integer.MIN_VALUE;
            for(int i=0;i<happiness.length;i++){
                if(happiness[i]!=0){
                    happiness[i]--;
                }
            }
            k--;
        }
        return ans;
    }
    public static long maximumHappinessSum(int[] happiness, int k) {
        long ans=0l;
        int c=0;
        Arrays.sort(happiness);
        for(int i=happiness.length-1;i>=0&&c<k;i--){
            if(happiness[i]>0){
                happiness[i]-=c;
            }
            ans+=happiness[i]>=0?happiness[i]:0;

            c++;
        }
        return ans;
    }

}
