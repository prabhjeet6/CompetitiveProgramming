package leetcode.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/diagonal-traverse/description/
class Coordinates {
    int x;
    int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Coordinates>> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!map.containsKey(i + j)) {
                    List<Coordinates> ls = new ArrayList<>();
                    Coordinates p = new Coordinates(i, j);
                    ls.add(p);
                    map.put(i + j, ls);
                } else {
                    List<Coordinates> ls = map.get(i + j);
                    ls.add(new Coordinates(i, j));
                    map.put(i + j, ls);
                }
            }
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int counter = 0;
        for (int i = 0; i < map.size(); i++) {
            List<Coordinates> ls = map.get(i);
            if (i % 2 == 0) {
                ls.sort((p1, p2) -> p1.y - p2.y);
            }

            for (Coordinates p : ls) {
                ans[counter++] = mat[p.x][p.y];

            }
        }
        return ans;
    }
}