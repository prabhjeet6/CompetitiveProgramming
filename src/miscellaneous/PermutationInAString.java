package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Given two strings s1 and s2, print True if s2 contains a permutation of s1,
 * or False otherwise.
 * 
 * In other words, print True if one of s1’s permutations is the substring of
 * s2.
 * 
 * Input Format
 * 
 * First-line will contain T,number of test cases. Then Each test case contains
 * string s1 and string s2. Output Format
 * 
 * For each test case, print True if s2 contains a permutation of s1 or False
 * otherwise. Sample Input 1
 * 
 * 2 ab eidbaooo ab eidboaoo Sample Output 1
 * 
 * True False Explanation
 * 
 * For s1=ab and s2=eidbaooo,s2 contains one permutation of s1 ("ba").
 * Constraints
 * 
 * 1 <= T <= 10 1 <= s 1. l e n g t h , s 2. l e n g t h <= 10 5 s1 and s2
 * consists of lowercase English letters. 1 <= k <= s . l e n g t h Example
 * Input 2 ab eidbaooo ab eidboaoo Output True False
 */
public class PermutationInAString {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < T; i++) {
			String s1 = bufferedReader.readLine();// small String
			String s2 = bufferedReader.readLine();// bigger String
			// Find Frequency of characters in s1, compare that with s2's window of size s1,
			// in case it matches for any of the windows. s2 has a perutation of s1
			System.out.println(IsS1PermutationSubStringOfS2(s1, s2));

		}

	}

	private static String IsS1PermutationSubStringOfS2(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return "False";
		}
		int s1Frequency[] = new int[26];
		int windowFrequency[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1Frequency[s1.charAt(i) - 'a']++;
			windowFrequency[s2.charAt(i) - 'a']++;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			if (matches(s1Frequency, windowFrequency)) {
				return "True";
			} else {
				windowFrequency[s2.charAt(i) - 'a']++;
				windowFrequency[s2.charAt(i - s1.length()) - 'a']--;
			}
		}
		if (matches(s1Frequency, windowFrequency))
			return "True";
		return "False";
	}

	static boolean matches(int freq1[], int freq2[]) {
		for (int i = 0; i < 26; i++) {
			if (freq1[i] != freq2[i]) {
				return false;
			}
		}
		return true;
	}
}
