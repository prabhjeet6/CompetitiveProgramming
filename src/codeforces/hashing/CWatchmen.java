package codeforces.hashing;


import java.io.*;
import java.util.*;

public class CWatchmen {
    public static void main(String arg[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] xy = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Pair p = new Pair();
            p.x = xy[0];
            p.y = xy[1];
            pairs.add(p);
        }
        int count = getEqualDistanceCount(n, pairs);
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
    private static int getEqualDistanceCount(int n, List<Pair> pairs) {
        Set<Pair> set = new HashSet<>();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        int duplicates = 0;
        for (int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);
            if (set.contains(p)) {
                duplicates++;
            }
            set.add(p);

            if(!xMap.containsKey(p.x)){
                xMap.put(p.x,  1);
            }else{
                int val=xMap.get(p.x);
                xMap.put(p.x,val+1);
            }
            if(!yMap.containsKey(p.y)){
                yMap.put(p.y,  1);
            }else{
                int val=yMap.get(p.y);
                yMap.put(p.y,val+1);
            }
        }
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
            int val = xMap.get(entry.getKey());
            ans += (val * (val - 1)) / 2;
        }
        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            int val = yMap.get(entry.getKey());
            ans += (val * (val - 1)) / 2;
        }
        return ans - duplicates;
    }
}

class Pair {
    int x;
    int y;

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