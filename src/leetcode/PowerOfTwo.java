package leetcode;


class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return checkPower(n, 1);

    }

    boolean checkPower(long n, long m) {
        if (n == m) {
            return true;
        }
        if (m > n) {
            return false;
        }
        return checkPower(n, m * 2);

    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return (n % 2 == 0) && isPowerOfTwo(n / 2);
    }
}
