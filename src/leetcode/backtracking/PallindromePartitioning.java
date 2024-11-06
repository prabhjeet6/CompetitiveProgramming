package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=WBgsABoClE0
//https://leetcode.com/problems/palindrome-partitioning/description/
class PallindromePartitioning{
    public static void main(String asd[]){
        System.out.println(new PallindromePartitioning().partition("aab"));
    }
    List<String> path=new ArrayList<>();
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
       backtrack(s,0,path,ans);
       return ans;
    }
    void backtrack(String s,int index,List<String> path,List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPallindrome(s,index,i)){
               path.add(s.substring(index,i+1));
               backtrack(s,i+1,path,ans);
               path.remove(path.size()-1);
            }
        }
    }

    private boolean isPallindrome(String s, int start, int end) {
        while(start<=end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


}
