package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://codeforces.com/contest/580/problem/B
public class KefaAndCompany {
    public static void main(String[] a) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nD = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nD[0]);
        long d = Long.parseLong(nD[1]);
        long[] money = new long[n];
        long[] fF = new long[n];
        for (int i = 0; i < n; i++) {
            String[] mFF = bufferedReader.readLine().split(" ");
            money[i] = Integer.parseInt(mFF[0]);
            fF[i] = Integer.parseInt(mFF[1]);
        }
        //bruteForce(money, fF, n, d);
        usingTwoPointersAndSorting(money, fF, n, d);
    }

    static void bruteForce(long[] money, long[] fF, int n, long d) {
        List<Integer> exclusions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && Math.abs(money[i] - money[j]) >= d) {
                    int index = fF[i] < fF[j] ? i : j;
                    exclusions.add(index);
                }
            }
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (!exclusions.contains(i)) {
                total += fF[i];
            }
        }
        System.out.println(total);
    }

    //To fix this, sort the friends based on their money values, and then use a sliding window (or two-pointer) technique.
//Keep l as the start of the current valid range. Move r to expand the window to include friends with money within the d range from money[l].
// Calculate the friendship factor sum for this range, and then maximize it.
    static void usingTwoPointersAndSorting(long[] money, long[] fF, int n, long d) {
        //Two Pointers often requires sorting beforehand
        List<MoneyAndFF> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            MoneyAndFF mFF = new MoneyAndFF();
            mFF.money = money[i];
            mFF.fF = fF[i];
            ls.add(mFF);
        }
        //money is sorted from left to right
        ls.sort(new MoneyAndFFComp());
        int l = 0;
        long sum = 0, currentSum = 0;
        for (int r = 0; r < n; r++) {
            //keep on adding friendship factor
            currentSum += ls.get(r).fF;
            while (ls.get(r).money - ls.get(l).money >= d) {
                //if above condition becomes true, reduce l's contribution and increase l, because
                //when l increases, money increases, as list is sorted on money and hence
                // condition ls.get(r).money-ls.get(l).money 's value decreases
                currentSum -= ls.get(l).fF;
                l++;
            }
            //if currentSum is smaller, discard
            sum = Math.max(sum, currentSum);
        }


        System.out.println(sum);
    }
}

class MoneyAndFFComp implements Comparator<MoneyAndFF> {
    @Override
    public int compare(MoneyAndFF o1, MoneyAndFF o2) {
        return Long.compare(o1.money, o2.money);
    }
}

class MoneyAndFF {
    long money;
    long fF;
}