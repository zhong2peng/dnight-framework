/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Solution {

    /**
     * Given an integer, write a function to determine if it is a power of three.
     * <p>
     * Example 1:
     * <p>
     * Input: 27
     * Output: true
     * Example 2:
     * <p>
     * Input: 0
     * Output: false
     * Example 3:
     * <p>
     * Input: 9
     * Output: true
     * Example 4:
     * <p>
     * Input: 45
     * Output: false
     * Follow up:
     * Could you do it without using any loop / recursion?
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        double a = Math.log(n) / Math.log(3);
        return Math.abs(a - Math.rint(a)) <= 0.000000000000001;
    }
}
