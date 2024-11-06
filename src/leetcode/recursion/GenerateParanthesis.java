package leetcode.recursion;


import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        balancedParanthesis("",n,0,0,res);
        return res;

    }
    void balancedParanthesis(String s,int n,int l,int r,List<String> res){
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if(l==r){
            balancedParanthesis(s+"(",n,l+1,r,res);
        }
        if(l>r){
            if(l==n){
                balancedParanthesis(s+")",n,l,r+1,res);
            }else{
                balancedParanthesis(s+"(",n,l+1,r,res);
                balancedParanthesis(s+")",n,l,r+1,res);
            }
        }
    }
}