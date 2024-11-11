package leetcode.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Given a string S and an integer K, print the maximum number of vowel letters
 * in any substring of S with length K.
 * 
 * Vowel letters in English are a, e, i, o, and u.
 * 
 * Input Format
 * 
 * First-line will contain T, number of test cases. Then Each test case contains
 * string S and an integer K. Output Format
 * 
 * For each test case, print the maximum number of vowel letter in any substring
 * of S with length K on a separate line. Sample Input 1
 * 
 * 3 abciiidef 3 aeiou 2 leetcode 3 Sample Output 1
 * 
 * 3 2 2 Explanation
 * 
 * For S=abciiidef and K=3 The substring "iii" contains 3 vowel letters.
 * Constraints
 * 
 * 1 <= T <= 10 1 <= s . l e n g t h <= 10 5 s consists of lowercase English
 * letters 1 <= k <= s . l e n g t h
 */
public class MaximumNumberOfVowels {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < numberOfTestCases; i++) {
			String input[] = bufferedReader.readLine().split(" ");
			String inputString = input[0];
			int k = Integer.parseInt(input[1]);
			calculateMaxVowels(inputString, k);

		}

	}

	private static void calculateMaxVowels(String inputString, int k) {
		int maxNumberOfVowels = 0;
		for (int i = 0; i < k; i++) {
			if (inputString.charAt(i) == 'a' || inputString.charAt(i) == 'e' || inputString.charAt(i) == 'i'
					|| inputString.charAt(i) == 'o' || inputString.charAt(i) == 'u') {
              maxNumberOfVowels++;
			}
		}
		int vowelsInCurrentWindow=maxNumberOfVowels;
		for(int i=k;i<inputString.length();i++) {
		      	
			if (inputString.charAt(i) == 'a' || inputString.charAt(i) == 'e' || inputString.charAt(i) == 'i'
					|| inputString.charAt(i) == 'o' || inputString.charAt(i) == 'u') {
              vowelsInCurrentWindow++;
			}
			if (inputString.charAt(i-k) == 'a' || inputString.charAt(i-k) == 'e' || inputString.charAt(i-k) == 'i'
					|| inputString.charAt(i-k) == 'o' || inputString.charAt(i-k) == 'u') {
              vowelsInCurrentWindow--;
			}
			if(vowelsInCurrentWindow>maxNumberOfVowels) {
				maxNumberOfVowels=vowelsInCurrentWindow;
			}
		}
		System.out.println(maxNumberOfVowels);
	}

}
