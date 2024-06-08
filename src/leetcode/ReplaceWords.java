package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public static void main(String arg[]){
        List<String >dictionary =new ArrayList<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        System.out.println(replaceWordsBruteForce(dictionary,"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }

    public static String replaceWordsBruteForce(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        String[] replacement = new String[words.length];
        for (String root : dictionary) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.startsWith(root)) {
                    if(null==replacement[i]){
                        replacement[i] = root;
                    }else if(root.length()<replacement[i].length()){

                        replacement[i] = root;
                    }

                }
            }

        }
        for (int i = 0; i < words.length; i++) {
            if (null != replacement[i]) {
                words[i] = replacement[i];
            }
        }
        String res = "";
        for (int i = 0; i < words.length; i++) {
            res += words[i] + " ";
        }
        return res.trim();
    }


        public String replaceWordsusingHashCode(List<String> dictionary, String sentence) {
            String[] wordArray = sentence.split(" ");
            Set<String> dictSet = new HashSet<>(dictionary);

            // Replace each word in sentence with the corresponding shortest root
            for (int i = 0; i < wordArray.length; i++) {
                wordArray[i] = shortestRoot(wordArray[i], dictSet);
            }

            return String.join(" ", wordArray);
        }

        private String shortestRoot(String word, Set<String> dictSet) {
            // Find the shortest root of the word in the dictionary
            for (int i = 1; i <= word.length(); i++) {
                String root = word.substring(0, i);
                if (dictSet.contains(root)) {
                    return root;
                }
            }
            // There is not a corresponding root in the dictionary
            return word;
        }

}