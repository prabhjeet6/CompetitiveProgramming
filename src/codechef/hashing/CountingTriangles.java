package codechef.hashing;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;

class CountingTriangles {
    public static void main(String[] args) throws java.lang.Exception {
        Map<Integer, Integer> xmap = new HashMap<>();
        Map<Integer, Integer> ymap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int points = sc.nextInt();
        int[][] pointsArr = new int[points][2];
        int count = 0;
        for (int i = 0; i < points; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            pointsArr[i][0] = x;
            pointsArr[i][1] = y;
            xmap.put(x, xmap.getOrDefault(x, 0) + 1);
            ymap.put(y, ymap.getOrDefault(y, 0) + 1);
        }
        for (int i = 0; i < points; i++) {
            int x = pointsArr[i][0];
            int y = pointsArr[i][1];
            int xcount = (xmap.get(x)) % 10000;
            int ycount = (ymap.get(y)) % 10000;
            count += (((xcount - 1) * (ycount - 1))) % 10000;
            count = (count % 10000);
        }

        System.out.println(count);
        sc.close();
    }
}