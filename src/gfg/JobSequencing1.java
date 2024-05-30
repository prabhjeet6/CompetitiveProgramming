package gfg;


//{ Driver Code Starts

import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobSequencing1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            S ob = new S();

            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class S {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        boolean isSlotFilled[] = new boolean[n];
        int totalProfit = 0, numberOfJobsDone = 0;
        //sort for max profit
        Arrays.sort(arr, new JobComparator());
        for (int i = 0; i < arr.length; i++) {
            //in case deadline is greater than n, otherwise,
            //if, I will write inner loop like for(j->0 to deadline), then, it will fill up slot, that
            // could otherwise be filled up by a task that has a smaller deadline, hence, we will use
            // nested loop as below going n to deadline
            for (int j = Math.min(n - 1, arr[i].deadline - 1); j >= 0; j--) {
                if (!isSlotFilled[j]) {
                    isSlotFilled[j] = true;
                    numberOfJobsDone++;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        int result[] = new int[2];
        result[0] = numberOfJobsDone;
        result[1] = totalProfit;
        return result;

    }
}

class JobComparator implements Comparator<Job> {
    public int compare(Job j1, Job j2) {
        if (j2.profit > j1.profit) {
            return 1;
        } else if (j2.profit < j1.profit) {
            return -1;
        } else {
            return 0;
        }
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
*/