/*A string containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"

'B' -> "2"

...

'Z' -> "26"

We have been given an encoded string containing only digits, We have to find the number of ways to decode it.

Input: “121”

Output: 3
*/

//https://leetcode.com/problems/decode-ways/description/
package leetcode;

class CountOfDecodings1BottomTopDP {

    public static void main(String[] as) {
        String encodedMessage = "226";
        System.out.println(numDecodingsBottomTopDP(encodedMessage));
    }



    //Bottom-Top DP solution
    public static int numDecodingsBottomTopDP(String s) {

      int[] dp=new int[s.length()+1];
      dp[0]=1; //Assuming dp[0] for empty String
      dp[1]='0'==s.charAt(0)?0:1;
      for(int i=2;i<=s.length();i++){
          int first=Integer.parseInt(s.substring(i-1,i));
          int second=Integer.parseInt(s.substring(i-2,i));
          if(1<=first&&first<=9){
           dp[i]+=dp[i-1];
          }
          if(second>=10&&second<=26){
              dp[i]+=dp[i-2];
          }

      }
      return dp[s.length()];
    }

    //Bottom-Top Alternative
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 1; i < n; i++) {
            int first = Integer.valueOf(s.substring(i, i+1));
            int second = Integer.valueOf(s.substring(i-1, i+1));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += i >=2 ? dp[i-2] : 1;
            }
        }
        return dp[n-1];
    }

}