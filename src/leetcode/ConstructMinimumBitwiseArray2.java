package leetcode;


import java.util.List;
//https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/submissions/1422301253/
//https://www.youtube.com/watch?v=1qKoz1PYhxc

class ConstructMinimumBitwiseArray2 {

    //The idea here is that when we do x|(x+1), then, for example, if x is
    // 101(value 5 in decimal, and a prime number as described in the problem),
    // then (x+1) is 110(bits from the first 0 from the right hand side flip),
    //when we apply '|' on it, the bits before the first 0 in x remain unchanged, and,
    // that 0 bit becomes 1 , bits on its right hand side are already 1.  101|110->111
    // for x|(x+1) to be equal to y, we can convert the left most 1 in the group of
    //consecutive 1s on the right hand side to 0 in binary representation of y
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            //only even prime number
            if (num == 2) {
                ans[i] = -1;
                continue;
            }

            int numCopy = num;
            int count = 0;
            // Count consecutive 1s from the right
            while ((num & 1) == 1) {
                count++;
                num >>= 1;
            }

            // [count]th bit is the position of the last 1, like 100111 (count = 3)
            // Subtract the bit
            // (basically, convert the left most 1 in the group of
            //consecutive 1s on the right hand side to 0 )
            ans[i] = numCopy - (1 << (count - 1));
        }

        return ans;
    }
}