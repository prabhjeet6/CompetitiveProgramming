package gfg;//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

public class MaximumMeetings {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Sol().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Pair implements Comparator<Pair>{
    int start;
    int end;

    Pair(int start,int end){
        this.start=start;
        this.end=end;
    }
    Pair(){

    }
    public int compare(Pair p1,Pair p2){
        if(p1.end>p2.end)
            return 1;
        if(p1.end<p2.end)
            return -1;
        return 0;
    }
}
class Sol
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Pair> list=new ArrayList<Pair>();
        for(int i=0;i<n;i++){
            list.add(new Pair(start[i],end[i]));
        }
        int count=0;
        Collections.sort(list,new Pair());
        Pair prev=new Pair(0,0);
        for(int i=0;i<n;i++ ){
            Pair p=list.get(i);

            if(p.start>prev.end&&p.start!=prev.start){
                count++;
                prev=p;
            }


        }
        return count;

    }
}
