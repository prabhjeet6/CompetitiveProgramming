package leetcode.math;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
class NumberOfWaysToDivideALongCorridor {

    public static void main(String[] a) {
        //between every two corridors is the number of ways they can be arranged
        //SS|PPSPS|
        //SSP|PSPS|
        //SSPP/SPS|
        System.out.println(numberOfWays("SSPPSPS"));
    }

    public static int numberOfWays(String corridor) {
        int mod = 1000000007;
        int n = corridor.length();
        int total = 0, count = 0;
        for (int i = 0; i < n; i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                total++;
            }
        }
        if (total == 0 || total % 2 == 1) {
            return 0;
        }
        int start = -1, end = -1;
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                count++;
            }
            if (count == 2 && start == -1) {
                start = i;
            }
            if (count == 3) {
                end = i;
                ways.add((end - start) % mod);
                count = 1;
                start = -1;
                end = -1;
            }
        }
        //take ans as long and then typecast after modulo operation
        long ans = 1L;
        for (int way : ways) {
            ans = ((ans) % mod * (way) % mod) % mod;
        }
        return (int) ans;
    }
}
