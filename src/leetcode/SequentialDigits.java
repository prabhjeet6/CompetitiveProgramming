package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String asf[]) {
        System.out.print(sequentialDigits(123, 1013));
    }


    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> seq = new ArrayList<Integer>();
        generateSeq(low, high, 0, 0, seq);
        Collections.sort(seq);
        return seq;
    }

    /*** example:- low = 1000, high = 12000
     where low is the minimum of sequential digits we have and high is up to what you can have.
     Since our lower limit is 1000 the sequence has to be of 4 digit.
     So, we can choose it from the range 1,2,3,4,5,6,7,8,9
     So, what possible sequential digits we could have is lying in our range from 1000 to 12000 is :-
     [1234,2345,3456,4567,5678,6789]

     Basic Idea is to generate only those numbers which are sequential so, that you
     don't have to recurse for other possibilities
     */
    static void generateSeq(int low, int high, int num, int i, List<Integer> seq) {

        if (num > high) return;

        if (num <= high && num >= low) seq.add(num);

        if (i == 0) {
            for (int j = 1; j <= 8; j++) {
                generateSeq(low, high, num * 10 + j, j + 1, seq);
            }
        } else if (num % 10 < 9)
            generateSeq(low, high, num * 10 + i, i + 1, seq);
    }


   /* //Gives MLE after two tests
   public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        recurse(low,high,list);
        return list;

    }


   static void  recurse(int low,int high,List<Integer>list){
        if(low==high+1){
            return ;
        }

        int currentDigit=low%10;
        int lowCopy=low/10;
        int nextDigit=lowCopy%10;
        if(recurseForDigits(lowCopy,currentDigit,nextDigit)){
            list.add(low);
        }
        recurse(low+1,high,list);

    }
    static boolean recurseForDigits(int low,int currentDigit , int nextDigit){
        if(low/10==0&&low<10){
            return currentDigit-1==nextDigit;
        }
        if(currentDigit-1!=nextDigit){
            return false;
        }else{

            currentDigit=nextDigit;
            low=low/10;
            nextDigit=low%10;

        }
        return recurseForDigits( low, currentDigit ,  nextDigit);

    }

*/
}
