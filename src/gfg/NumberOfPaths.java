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