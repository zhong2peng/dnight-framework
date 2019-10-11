/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class Solution {

    /**
     * wrong answer
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int start = 1;
        while (start < n && start > 1) {
            int mid = (start + n) / 2;
            if (mid >= 2 && isBadVersion(mid) && isBadVersion(mid - 1)) {
                n = mid - 1;
            } else if (mid >= 2 && !isBadVersion(mid) && !isBadVersion(mid - 1)) {
                start = mid + 1;
            } else {
                if (!isBadVersion(mid)) {
                    return mid + 1;
                }
                return mid;
            }
        }
        return 1;

    }

    public int firstBadVersion1(int n) {
        if (isBadVersion(1)) {
            return 1;
        }

        int i = 1;
        int j = n;

        while (i < j) {
            int mid = (j + i) / 2 + 1;
            if (!isBadVersion(mid)) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }

        return j + 1;
    }

    public boolean isBadVersion(int version) {
        return true;
    }
}
