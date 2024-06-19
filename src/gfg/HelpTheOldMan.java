package gfg;


import java.util.ArrayList;
import java.util.List;

class MovePair{
    int source;
    int destination;
}
public class HelpTheOldMan{
    static List<Integer> shiftPile(int N, int n){
        List<MovePair> moves=new ArrayList<>();
        towersOfHanoi(1,2,3,N,moves);
        List<Integer> ans=new ArrayList<>();
        ans.add(moves.get(n-1).source);
        ans.add(moves.get(n-1).destination);
        return ans;

    }
    //Step 1: Transfer first N-1 plates from box 1 to box 2 using box 3.
    //Step 2: Transfer the remaining plate from box 1 to box 3.
    //Step 3: Transfer the first N-1 plates from box 2 to box 3 using box 1.
    static void  towersOfHanoi(int source,int helper,int destination,int N,List<MovePair> res){

        if(N==1){
            MovePair movePair=new MovePair();
            movePair.source=source;
            movePair.destination=destination;
            res.add(movePair);
            return;
        }
        towersOfHanoi(source,destination,helper,N-1,res);
        MovePair movePair=new MovePair();
        movePair.source=source;
        movePair.destination=destination;
        res.add(movePair);
        towersOfHanoi(helper,source,destination,N-1,res);
    }
}
