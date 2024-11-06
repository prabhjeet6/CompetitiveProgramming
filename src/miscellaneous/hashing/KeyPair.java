package miscellaneous.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class KeyPair {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String NK[] = bufferedReader.readLine().split(" ");
        int N = Integer.valueOf(NK[0]);
        int K = Integer.valueOf(NK[1]);
        int arr[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findKeyPairUsingHashTable(arr, K);
    }

    private static void findKeyPairUsingHashTable(int[] arr, int K) {
        String ans = "No";
        Map<Integer, Integer> hashTable = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            int freq = hashTable.getOrDefault(arr[i], 0);
            hashTable.put(arr[i], freq + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (hashTable.containsKey(K - arr[i])) {
                if ((arr[i] == (K - arr[i]) && hashTable.get(arr[i]) > 1) || arr[i] != (K - arr[i])) {
                    ans = "Yes";
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}