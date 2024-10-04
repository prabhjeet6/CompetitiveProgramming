package codeforces;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
//https://codeforces.com/contest/713/problem/A
public class SonyaAndQueries {
    public static void main(String[] as) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            if ("+".equals(query[0])) {
                String parityPattern=getParityPattern(query[1]);
                map.put(parityPattern,map.getOrDefault(parityPattern,0)+1);
            } else if ("-".equals(query[0])) {
                String parityPattern=getParityPattern(query[1]);
                map.put(parityPattern,map.getOrDefault(parityPattern,0)-1);
            } else {
                System.out.println(map.getOrDefault(getPaddedParity(query[1]),0));
            }
        }
    }

    private static String getParityPattern(String s) {
        StringBuilder parityPattern=new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            parityPattern.append((s.charAt(i)-'0')%2);
        }
        while(parityPattern.length()<18){
            parityPattern.append('0');
        }
        return parityPattern.reverse().toString();
    }

    private static String getPaddedParity(String s) {
        StringBuilder paddedParity=new StringBuilder(s);
        while(paddedParity.length()<18){
            paddedParity.insert(0,'0');
        }
        return paddedParity.toString();
    }

}