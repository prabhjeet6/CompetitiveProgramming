package leetcode;


class StrictlyPallindromicNumber {
    public boolean isStrictlyPalindromic(int n) {
        boolean isPallindrome=true;
        for(int i=2;i<=n-2;i++){
            isPallindrome=checkIfPallindrome(n,convertToIthBase(n,i));
            if(!isPallindrome){
                return isPallindrome;
            }
        }
        return isPallindrome;
    }
    String convertToIthBase(int n,int i){
        //String pallindromeString=" ";
        StringBuilder pallindromeString=new StringBuilder();
        while(n>1){
            //pallindromeString+=n%i;
            pallindromeString.append(n%i);
            n=n/i;
        }
        return  pallindromeString.toString();
    }
    boolean checkIfPallindrome(int m,String n){
        return String.valueOf(m).equals(n);
    }
}