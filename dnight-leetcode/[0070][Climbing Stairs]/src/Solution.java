/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Solution {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * Note: Given n will be a positive integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * <p>
     * 爬楼梯，每次走 1 个或 2 个台阶，n 层的台阶，总共有多少种走法。
     * <pre>
     * 设f(n) 表示爬n 阶楼梯的不同方法数，为了爬到第n 阶楼梯，有两个选择：
     * - 从第n - 1 阶前进1 步；
     * - 从第n - 1 阶前进2 步；
     * 因此，有f(n) = f(n - 1) + f(n - 2)。
     * </pre>
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else if (n > 2) {
            int[] ways = new int[n];
            ways[0] = 1;
            ways[1] = 2;
            for (int i = 2; i < ways.length; i++) {
                ways[i] = ways[i - 2] + ways[i - 1];
            }
            result = ways[ways.length - 1];
        }
        return result;
    }
}
