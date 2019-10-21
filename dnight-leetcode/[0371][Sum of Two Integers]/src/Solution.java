/**
 * @author ZHONGPENG769
 * @date 2019/10/16
 */
public class Solution {

    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     * <p>
     * Example 1:
     * <p>
     * Input: a = 1, b = 2
     * Output: 3
     * Example 2:
     * <p>
     * Input: a = -2, b = 3
     * Output: 1
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
