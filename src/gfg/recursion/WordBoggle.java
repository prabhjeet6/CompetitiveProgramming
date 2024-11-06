package gfg.recursion;

//User function Template for Java

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

class WordBoggle
{
    private boolean dfs(int row,int col,int index,char[][] board,boolean[][] visited,String word){
        if(index==word.length())
            return true;

        int n=board.length;
        int m=board[0].length;

        if(row<0 || row>=n || col<0 || col>=m || visited[row][col] || board[row][col]!=word.charAt(index))
            return false;
        //mark visited[row][col] as true at the start of dfs call
        visited[row][col]=true;

        int[] delRow={-1,-1,0,1,1,1,0,-1};
        int[] delCol={0,1,1,1,0,-1,-1,-1};

        for(int i=0;i<8;i++){
            if(dfs(row+delRow[i],col+delCol[i],index+1,board,visited,word)){
                //mark visited[row][col] as false after every recursive call
                visited[row][col]=false;
                return true;
            }
        }
        //mark visited[row][col] as false at the end of dfs call
        visited[row][col]=false;
        return false;
    }
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        int n=board.length;
        int m=board[0].length;

        boolean[][] visited=new boolean[n][m];

        ArrayList<String> result=new ArrayList<>();

        for(String x : dictionary){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]==x.charAt(0) && dfs(i,j,0,board,visited,x))
                        result.add(x);
                }
            }
        }

        Set<String> set=new LinkedHashSet<>(result);

        return set.toArray(new String[0]);
    }
}