package leetcode.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.length() >=i + 10) {
                String sequence = s.substring(i, i+10);
                map.put(sequence, map.getOrDefault(sequence, 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            if (map.get(key) > 1) {
                res.add(key);
            }
        }

        return res;
    }
}
