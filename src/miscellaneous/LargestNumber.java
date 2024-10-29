package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LargestNumber {
    public static void main(String[] s) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            printLargestNumber(nums);
        }
    }

    static void printLargestNumber(int[] nums) {
        List<Nums> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new Nums(num));
        }
        Collections.sort(list, new NumComparator());
        StringBuilder res = new StringBuilder();
        for (Nums n : list) {
            res.append(n.value);
        }
        System.out.println(res);
    }
}

class Nums {
    public Nums(int value) {
        this.value = value;
    }

    int value;
}

class NumComparator implements Comparator<Nums> {

    @Override
    public int compare(Nums o1, Nums o2) {
        int num1 = o1.value;
        int num2 = o2.value;
        int ans=0;
        while (num1 > 0 || num2 > 0) {
            int r1 = num1 % 10;
            int r2 = num2 % 10;
            if (r1 != r2) {
                ans=Integer.compare(r2, r1);
                break;
            } else {
                num1 /= 10;
                num2 /= 10;
            }
        }
        return ans;
    }
}

