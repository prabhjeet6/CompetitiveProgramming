package leetcode.backtracking;


import java.util.HashSet;
import java.util.Set;


class LetterTilePossibilities {

    //Unrelated dfs backtracking: https://www.youtube.com/watch?v=8Vrb7ZjVqPg
    //DFS backtracking solution

    /*
Algorithm:
----------------------------------------------------------------------------------------
1. Simple `backtracking` approach.
2. The idea is to add characters one by one of the input string (tiles) to a temporary
   string which is further added to a HashSet to avoid repetition.
3. While doing so the characters which are once visited should be skipped for that
   maintain a `visited` array of size same as that of the entire string.
4. In each recursion call, add the temporary strings into the HashSet.
5. When the recursion call is over, the set is filled with all strings, which includes
   the `null` as well.
6. Hence return the size of the set -1. That `-1` corresponds to the `null` string.
----------------------------------------------------------------------------------------
*/
    public static void main(String as[]){
        System.out.println(new LetterTilePossibilities().numTilePossibilities("aab"));
    }

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        permute(tiles, "", set, vis);

        return set.size()-1;
    }
    public void permute(String tiles, String curr, Set<String> set, boolean[] vis){

        set.add(curr);
        for(int i=0; i<tiles.length(); i++){
            if(!vis[i]){
                vis[i]=true;
                permute(tiles, curr+tiles.charAt(i), set, vis);
                vis[i]=false;
            }
        }
    }
}
