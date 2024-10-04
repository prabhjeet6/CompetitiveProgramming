package codeforces;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
//https://codeforces.com/contest/713/problem/A
public class SonyaAndQueries {

    //Instead of directly storing the numbers in the multiset, we convert each number into a parity
    // pattern. This parity pattern is then stored in a HashMap (or Map) with its frequency.
    // The parity pattern is derived by checking whether each digit of the number is even or odd,
    // and then padding the result with zeros to make it 18 characters long.
    // Use a Map<String, Integer> to store the frequency of each parity pattern.
    // This allows efficient addition (+ query), removal (- query), and querying (? query) operations,
    // each of which can be done in O(1) time (on average).
    //For the ? query, instead of filtering the list of integers, we directly look up the precomputed
    // parity pattern of the query string in the map. This reduces the time complexity drastically
    // because:Matching a pattern is simply a matter of looking it up in the map, which is an O(1)
    // operation (amortized).

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