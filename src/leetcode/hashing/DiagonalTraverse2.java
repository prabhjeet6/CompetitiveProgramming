package leetcode.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DiagonalTraverse2 {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Coordinates>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
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

        //ans = new int[ansLen];

        for (int i = 0; i < map.size(); i++) {
            List<Coordinates> ls = map.get(i);
            ls.sort((p1, p2) -> p1.y - p2.y);
            if (!ls.isEmpty()) {
                for (Coordinates p : ls) {
                    if (!nums.get(p.x).isEmpty()) {
                        if (nums.get(p.x).get(p.y) != null) {
                            //System.out.print(nums.get(p.x).get(p.y) + " ");
                            //ans[count++] = nums.get(p.x).get(p.y);
                            ans.add(nums.get(p.x).get(p.y));

                        }
                    }
                }
            }
        }
        int[] res = new int[ans.size()];
        int count = 0;
        for (int r : ans) {
            res[count++] = r;
        }
        return res;
    }
}

class Coordinates {
    int x;
    int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
