package leetcode;
/**https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class KthLexicographicalString {
    List<String> list=new ArrayList<>();

    public static void main(String as[]){
        KthLexicographicalString ob=new KthLexicographicalString();
        ob.getHappyString(3,9);
        System.out.println(ob.list);
    }
    StringBuilder sb = new StringBuilder();
    public String getHappyString(int n, int k) {
        backtrack(n,' ');
        //Even sorting is not needed as backtrack is generating strings in lexicographical order
        //because it is looped in alphabetical order in every iteration
        //Collections.sort(list);
        if(list.size()<k) return "";
        else return list.get(k-1);
    }
    void backtrack(int n, char prev){
        if(sb.length()==n){
            list.add(sb.toString());
            return;
        }
        else{
            for(char  ch='a';ch<='c';ch++){
                if(ch!=prev){
                    sb.append(ch);
                    backtrack(n,ch);
                    sb.delete(sb.length()-1,sb.length());
                }

            }
        }
    }
}
