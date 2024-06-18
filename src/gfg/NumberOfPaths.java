package gfg;
public class NumberOfPaths{

    static long numberOfPaths(int M, int N) {
        if(M==1||N==1){
            return 1;
        }
        return numberOfPaths(M-1,N)+numberOfPaths(M,N-1);
    }

    public static void main(String arg[]){
        System.out.print(numberOfPaths(3,3));
    }
}
//Method2
//Instead of making count the part of recursion, as an argument, use count as class variable, that way, its value will not vanish
class NumberOfPaths2{
    static int cnt=0;
    static long numberOfPaths(int m, int n) {
        countAllPaths(0,0,m,n);
        return cnt;
    }
    static void countAllPaths(int i,int j,int m,int n){
        if(i==m-1||j==n-1){
            cnt++;
            return;
        }
        countAllPaths(i,j+1,m,n);
        countAllPaths(i+1,j,m,n);
    }
}