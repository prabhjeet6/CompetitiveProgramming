package codeforces.hashing;


import java.io.*;
import java.util.*;

public class CWatchmen {
    public static void main(String arg[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long[] xy = Arrays.stream(bf.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            Pair p = new Pair();
            p.x = xy[0];
            p.y = xy[1];
            pairs.add(p);
        }
        long count = getEqualDistanceCount(n, pairs);
        System.out.println(count);
    }

    private static int getEqualDistanceCountBruteForce(int n, List<Pair> pairs) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    Pair iPair = pairs.get(i);
                    Pair jPair = pairs.get(j);
                    double normalDistance = Math.sqrt((iPair.x - jPair.x) * (iPair.x - jPair.x) +
                            (iPair.y - jPair.y) * (iPair.y - jPair.y));
                    double manhattanDistance = Math.abs(iPair.x - jPair.x) + Math.abs(iPair.y - jPair.y);
                    if (normalDistance == manhattanDistance) {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    //(euclideanDistance)^2=(x1-x2)^2+(y1-y2)^2
    //(ManhattanDistance)^2=(|x1-x2|+|y1-y2|)^2 => (x1-x2)^2 - (y1-y2)^2 -2|x1-x2||y1-y2|
    //Inorder for Manhattan distance and euclideanDistance to be equal, |x1-x2||y1-y2| needs to be zero, that is, either x1 should be equal to x2
    //or, y1 should be equal to y2
    private static long getEqualDistanceCount(int n, List<Pair> pairs) {
        Map<Pair, Long> pointMap = new HashMap<>();
        Map<Long, Long> xMap = new HashMap<>();
        Map<Long, Long> yMap = new HashMap<>();
        long duplicates = 0;
        for (Pair p : pairs) {
            if (!pointMap.containsKey(p)) {
                pointMap.put(p, 1L);
            } else {
                long val = pointMap.get(p);
                pointMap.put(p, val + 1L);
            }

            if (!xMap.containsKey(p.x)) {
                xMap.put(p.x, 1L);
            } else {
                long val = xMap.get(p.x);
                xMap.put(p.x, val + 1);
            }
            if (!yMap.containsKey(p.y)) {
                yMap.put(p.y, 1L);
            } else {
                long val = yMap.get(p.y);
                yMap.put(p.y, val + 1L);
            }
        }
        //if there are n coordinates with equal x values, then first coordinate will have equal distance
        //with n-1 coordinates, second one will have equal distance with n-2 coordinates apart from the
        //first, and so on. hence, using   ans += (val * (val - 1)) / 2;
        //same logic applies when calculating for y coordinates or duplicates
        long ans = 0L;
        for (Map.Entry<Long, Long> entry : xMap.entrySet()) {
            long val = xMap.get(entry.getKey());
            ans += (val * (val - 1)) / 2;
        }
        for (Map.Entry<Long, Long> entry : yMap.entrySet()) {
            long val = yMap.get(entry.getKey());
            ans += (val * (val - 1)) / 2;
        }
        for (Map.Entry<Pair, Long> entry : pointMap.entrySet()) {
            long val = pointMap.get(entry.getKey());
            duplicates += (val * (val - 1)) / 2;
        }
        return (ans - duplicates);
    }
}

class Pair {
    long x;
    long y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}