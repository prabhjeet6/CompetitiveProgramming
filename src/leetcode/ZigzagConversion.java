package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public static void main(String[]a){
        System.out.println(convert("PAYPALISHIRING",4));
    }
    public static String convert(String s, int numRows) {
        if(numRows==1)return s;
        String[] zigZag=new String[numRows];
        Arrays.fill(zigZag,"");
        int stringIndex=0,visitedFlag=0;
        StringBuilder ans= new StringBuilder();
        while(stringIndex<s.length()){

            for(int i = visitedFlag; i<numRows; i++){
                if(stringIndex==s.length())break;
                zigZag[i]+= String.valueOf(s.charAt(stringIndex));
                stringIndex++;
            }
            visitedFlag=1;
            for(int i=numRows-1-visitedFlag;i>=0;i--){
                if(stringIndex==s.length())break;
                zigZag[i]+= String.valueOf(s.charAt(stringIndex));
                stringIndex++;
            }

        }
        for(String str:zigZag){
            ans.append(str);
        }
        return ans.toString();
    }
}
