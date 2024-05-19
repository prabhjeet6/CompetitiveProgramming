package leetcode;


public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]){
        //System.out.println(lengthOfLongestSubstring("bcbtbtablud"));
        System.out.println(lengthOfLongestSubstring("aab"));

    }

    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        String longestSubstring="";
        longestSubstring=longestSubstring.trim();
        int longestSubstringLength=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(!longestSubstring.contains(c.toString())){
                longestSubstring+=c.toString();
                if(longestSubstringLength<longestSubstring.length()){
                    longestSubstringLength=longestSubstring.length();
                }
            }else{
                for(int idx=0;idx<longestSubstring.length();idx++){
                    if(((Character)longestSubstring.charAt(idx)).equals(c)){
                        longestSubstring=longestSubstring.substring(idx+1,longestSubstring.length());
                        break;
                    }
                }
                longestSubstring+=c.toString();
            }
        }
        return longestSubstringLength;
    }
}