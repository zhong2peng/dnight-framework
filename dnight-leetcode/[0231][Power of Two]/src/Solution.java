/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given an integer, write a function to determine if it is a power of two.
     * <p>
     * Example 1:
     * <p>
     * Input: 1
     * Output: true
     * Explanation: 2^0 = 1
     * Example 2:
     * <p>
     * Input: 16
     * Output: true
     * Explanation: 2^4 = 16
     * Example 3:
     * <p>
     * Input: 218
     * Output: false
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if (n == 1) {
                return true;
            } else {
                if (n % 2 != 0) {
                    return false;
                }
                n = n >> 1;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
