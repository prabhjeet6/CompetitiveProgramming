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

import java.util.HashMap;
import java.util.Map;

class CountOfDecodings1Recursive {

    public static void main(String[] as) {

        String encodedMessage = "226";
        System.out.println(numDecodingsRecursive(encodedMessage));
    }

    //Recursive solution
    public static int numDecodingsRecursive(String s) {
        /*if(null==s || s.isEmpty()){
            return 0;
        }*/
        return countDecodings(s,  populateMap(),0,0);
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
    static int countDecodings(String encodedMessage,Map<String,Character> alphabetsMap,int i,int count) {
        if(i>=encodedMessage.length()){
            return count+1;
        }
        if(i+1<=encodedMessage.length()&&alphabetsMap.containsKey(encodedMessage.substring(i,i+1))){
            count=countDecodings( encodedMessage,alphabetsMap, i+1,count);
        }
        if(i+2<=encodedMessage.length()&&alphabetsMap.containsKey(encodedMessage.substring(i,i+2))){
            count= countDecodings( encodedMessage,alphabetsMap, i+2,count);
        }
        return count;
    }
}