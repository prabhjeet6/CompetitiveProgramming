package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CustomSort {
    public String customSortString(String order, String s) {
        Character[] res=new Character[s.length()];
        //convert your input to an Array, inorder to be able to write a comparator for this
        for(int i=0;i<s.length();i++){
            res[i]=s.charAt(i);
        }
        //Pass anonymous inner claas comparator
        Arrays.sort(res,(c1, c2)->{
            return order.indexOf(c1)-order.indexOf(c2);
        });
        String resString="";
        for(Character c:res){
            resString+=c;
        }
        return resString;
    }
    public String hashMap(String order, String s) {

        // Create a frequency table
        Map<Character, Integer> freq = new HashMap<>();

        // Initialize frequencies of letters
        // freq[c] = frequency of char c in s
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char letter = s.charAt(i);
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }

        // Iterate order string to append to result
        int K = order.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < K; i++) {
            char letter = order.charAt(i);
            while (freq.getOrDefault(letter, 0) > 0) {
                result.append(letter);
                freq.put(letter, freq.get(letter) - 1);
            }
        }

        // Iterate through freq and append remaining letters
        // This is necessary because some letters may not appear in `order`
        for (char letter : freq.keySet()) {
            int count = freq.get(letter);
            while (count > 0) {
                result.append(letter);
                count--;
            }
        }

        // Return the result
        return result.toString();

    }
}
