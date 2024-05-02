package leetcode;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversePrefixOfWord {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String word=bufferedReader.readLine();

        System.out.println(new ReversePrefixOfWord().reversePrefix(word,'d'));
    }

    public String reversePrefix(String word, char ch) {
        int pivot=-1;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            return word;
        }
        String resultant="";
        for(int i=pivot;i>=0;i--){
            resultant+=word.charAt(i);
        }
        for(int i=pivot+1;i<word.length();i++){
            resultant+=word.charAt(i);
        }


        return resultant.trim();
    }
}
