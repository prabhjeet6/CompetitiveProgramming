package leetcode;
/***https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/*/
import java.util.HashMap;
import java.util.Map;

public class LetterCombinations {

	public static void main(String[] args) {
		Map<Integer,String> dialMap=new HashMap<>();
		dialMap.put(2, "abc");
		dialMap.put(3, "def");
		dialMap.put(4, "ghi");
		dialMap.put(5, "jkl");
		dialMap.put(6, "mno");
		dialMap.put(7, "pqrs");
		dialMap.put(8, "tuv");
		dialMap.put(9, "wxyz");
		String digitString="2";
		letterCombinations(" ",digitString,dialMap,0,digitString.length());
	}
	static void letterCombinations(String letterCombination,String digitString,Map<Integer, String> dialMap,int idx,int digitStringLength) {
		
		if(digitStringLength==idx) {
			System.out.print(letterCombination);
			System.out.println();
			return;
		}
		for(int j=0;j<digitString.length();j++) {
		char activeDigit=digitString.charAt(j);
		digitString=digitString.replace(activeDigit, ' ').trim();
		String stringForDigit=dialMap.get(Integer.parseInt(String.valueOf(activeDigit)));
		for(int i=0;i<stringForDigit.length();i++) {
			char c=stringForDigit.charAt(i);
			
			
			//letterCombination+=" "+c;--> this would have caused,every character to be appended in subsequent recursion calls(i.e. a*,ba*,cab*)
			
			letterCombinations(letterCombination+c,digitString,dialMap,idx+1,digitStringLength);
		}
		}
		
	}

}
