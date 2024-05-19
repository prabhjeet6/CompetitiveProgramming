package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


    public static int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringUsingTwoPointers(s);
    }
    public static int lengthOfLongestSubstringUsingTwoPointers(String s){
        int maxLength=0;
        for(int right=0,left=0;right<s.length();right++){
            int indexOfFirstAppearanceInSubString=s.indexOf(s.charAt(right),left);
            if(indexOfFirstAppearanceInSubString!=right){
                left=indexOfFirstAppearanceInSubString+1;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    // TC O(N)
    //Two Pointers and HashMap
    public static int lengthOfLongestSubstringUsingHashMapAndTwoPointers(String s) {
    Map<Character,Integer> visitedCharacters=new HashMap<>();
    int maxLength=0;
    for(int right=0,left=0;right<s.length();right++){
        char currentCharacter=s.charAt(right);
        if(visitedCharacters.containsKey(currentCharacter)&&visitedCharacters.get(currentCharacter)>=left){
           left=visitedCharacters.get(currentCharacter)+1;
        }
        maxLength=Math.max(maxLength,right-left+1);
        visitedCharacters.put(currentCharacter,right);
    }
    return maxLength;


    }
    //TC O(N^2)
    public static int lengthOfLongestSubstringBruteForce(String s) {
        if ("".equals(s)) {
            return 0;
        }
        String longestSubstring = "";
        longestSubstring = longestSubstring.trim();
        int longestSubstringLength = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!longestSubstring.contains(c.toString())) {
                longestSubstring += c.toString();
                if (longestSubstringLength < longestSubstring.length()) {
                    longestSubstringLength = longestSubstring.length();
                }
            } else {
                for (int idx = 0; idx < longestSubstring.length(); idx++) {
                    if (((Character) longestSubstring.charAt(idx)).equals(c)) {
                        longestSubstring = longestSubstring.substring(idx + 1, longestSubstring.length());
                        break;
                    }
                }
                longestSubstring += c.toString();
            }
        }
        return longestSubstringLength;
    }
}