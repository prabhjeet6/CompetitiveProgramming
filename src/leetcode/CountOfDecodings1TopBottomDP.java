package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/decode-ways/solutions/3162837/java-3-solutions-with-clear-explanation-brute-force-dp/
public class CountOfDecodings1TopBottomDP {
    public static void main(String[] as) {
        String encodedMessage = "216";
        solveTopDownDP(encodedMessage);
    }
    static void solveTopDownDP(String encodedMessage){
        int[] dp=new int[encodedMessage.length()+1];
        Arrays.fill(dp,-1);

        System.out.println(numDecodingsTopBottomDP(encodedMessage,populateMap(),0,0,dp));
    }
    static Map<String,Character> populateMap(){
        Map<String,Character>map=new HashMap<>();
        char c=65;
        for(int i=1;i<=26;i++){
            map.put(String.valueOf(i),c);
            c++;
        }
        return map;
    }
    //Top Bottom DP
    static int numDecodingsTopBottomDP(String encodedMessage,Map<String,Character> alphabetsMap,int i,int count, int[] dp) {
        if(i == encodedMessage.length()) return 1;
        if(encodedMessage.charAt(i) == '0') return 0;

        if(dp[i]!=-1){
            return dp[i];
        }
        if(i+1<=encodedMessage.length()&&alphabetsMap.containsKey(encodedMessage.substring(i,i+1))) {
            count = numDecodingsTopBottomDP(encodedMessage, alphabetsMap, i + 1, count, dp);
        }
        if(i+2<=encodedMessage.length()&&alphabetsMap.containsKey(encodedMessage.substring(i,i+2))){
            count+= numDecodingsTopBottomDP( encodedMessage,alphabetsMap, i+2,count,dp);
        }
        dp[i]=count;

        return dp[i];
    }

}
