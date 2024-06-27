package leetcode;

import java.util.ArrayList;
import java.util.List;

//Go through Editorial
public class RestoreIPAddressesRecursive {
    private boolean valid(String s, int start, int length) {
        return (
                length == 1 ||
                        (s.charAt(start) != '0' &&
                                (length < 3 ||
                                        s.substring(start, start + length).compareTo("255") <= 0))
        );
    }


    private void helper(
            String s,
            int startIndex,
            List<Integer> dots,
            List<String> ans
    ) {
        final int remainingLength = s.length() - startIndex;
        final int remainingNumberOfIntegers = 4 - dots.size();
        //Very Important Condition: If number of remaining digits is more than maximum possible,
        // we can discard it here itself
        if (
                remainingLength > remainingNumberOfIntegers * 3 ||
                        remainingLength < remainingNumberOfIntegers
        ) {
            return;
        }
        if (dots.size() == 3) {
            if (valid(s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(startIndex));
                ans.add(sb.toString());
            }
            return;
        }
        for (
                int curPos = 1;
                curPos <= 3 && curPos <= remainingLength;
                ++curPos
        ) {
            // Append a dot at the current position.
            dots.add(curPos);
            // Try making all combinations with the remaining string.
            if (valid(s, startIndex, curPos)) {
                helper(s, startIndex + curPos, dots, ans);
            }
            // Backtrack, i.e. remove the dot to try placing it at the next position.
            dots.remove(dots.size() - 1);
        }
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }
}




// orthodox Backtracking
class RestoreIpAddresses {
    public  static void main(String asd[]){
        RestoreIpAddresses  restoreIpAddresses=new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));
    }

    static List<String> res=new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {

        List<String> address=new ArrayList<>();
        recurse(s,0,address);
        return res;
    }

    private static void recurse(String s, int i, List<String> address) {
        if(address.size()==4){
            if(i==s.length()) {
                res.add(address.get(0)+"."+address.get(1)+"."+address.get(2)+"."+address.get(3));
                return;
            }
        }
        for(int j=i+1;j<=i+3 && j<=s.length() ;j++){
            String partIpString=s.substring(i,j);
            Integer partIp=Integer.parseInt(partIpString);

            if(partIp<=255&&partIp>=0&&!partIpString.startsWith("0")){
                address.add(partIpString);
                recurse(s,j,address);
                address.remove(address.size()-1);
            }

        }
    }


}

