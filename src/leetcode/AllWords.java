package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AllWords {
    public static void main(String[] as) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    //Two Pass: fails last Test case
    public List<Integer> findSubstringTwoPass(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordsLength = words.length;
        int stringLength = s.length();
        int wordLength = words[0].length();
        if (stringLength == 0 || wordsLength == 0 || wordLength * wordsLength > stringLength) {
            return ans;
        }
        Map<String, Integer> wordsFrequency = new HashMap<>();
        for (String word : words) {
            wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < stringLength - (wordsLength * wordLength) + 1; i++) {
            for (int j = i; j < i + wordsLength * wordLength; j += wordLength) {
                String temp = s.substring(j, j + wordLength);
                tempMap.put(temp, tempMap.getOrDefault(temp, 0) + 1);
            }

            boolean found = true;
            for (int j = 0; j < wordsLength; j++) {
                if (!tempMap.containsKey(words[j]) || !wordsFrequency.get(words[j]).equals(tempMap.get(words[j]))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ans.add(i);
            }
            tempMap.clear();
        }
        return ans;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordsLength = words.length;
        int stringLength = s.length();
        int wordLength = words[0].length();
        if (stringLength == 0 || wordsLength == 0 || wordLength * wordsLength > stringLength) {
            return ans;
        }
        Map<String, Integer> wordsFrequency = new HashMap<>();
        for (String word : words) {
            wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < stringLength - (wordsLength * wordLength) + 1; i++) {
            //copies words Map for every iteration of i, where i represents index on the input String
            tempMap.putAll(wordsFrequency);
            for (int j = i; j < i + wordsLength * wordLength; j += wordLength) {
                String temp = s.substring(j, j + wordLength);
                if (tempMap.containsKey(temp)) {
                    int count = tempMap.get(temp);
                    if (count == 1) tempMap.remove(temp);
                    else tempMap.put(temp, count - 1);
                    if (tempMap.isEmpty()) {
                        //if at the end of nested loop, tempMap is empty, then,
                        // it is a permutation match
                        ans.add(i);
                        break;
                    }
                } else break;

            }

            tempMap.clear();
        }
        return ans;
    }
}