package miscellaneous.searching;

//https://leetcode.com/problems/first-bad-version/
class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1l, right = n, mid = 0l;
        while (left <= right) {
            mid = (left + right) / 2;
            if (!isBadVersion((int) mid)) {
                left = mid + 1;
            } else {
                if (!isBadVersion((int) (mid - 1))) {
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }
        return (int) mid;
    }
}