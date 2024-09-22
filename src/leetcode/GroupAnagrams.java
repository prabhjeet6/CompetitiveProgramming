package leetcode;

import java.util.*;

class GroupAnagrams {
    public static void main(String[] as) {
        //[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            StringBuilder sortedString= new StringBuilder();
            for(char c:temp){
                sortedString.append(c);
            }
            List<String> ls;
            if (map.containsKey(sortedString.toString())) {
                ls = map.get(sortedString.toString());
            } else {
                ls = new ArrayList<>();
            }
            ls.add(str);
            map.put(sortedString.toString(), ls);
        }
        return new ArrayList<>(map.values());
    }
}
