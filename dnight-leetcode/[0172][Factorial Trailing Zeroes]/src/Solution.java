/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Solution {

    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     * <p>
     * Example 1:
     * <p>
     * Input: 3
     * Output: 0
     * Explanation: 3! = 6, no trailing zero.
     * Example 2:
     * <p>
     * Input: 5
     * Output: 1
     * Explanation: 5! = 120, one trailing zero.
     * Note: Your solution should be in logarithmic time complexity.
     * <p>
     * You just need to count how many times 5 appears in n! during multiplication in different
     * forms: 5, 25, 125, 625, ... .
     * when any 5 is multiplied by 2 (we have many of them) then we get 0 at the end. That's it.
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
