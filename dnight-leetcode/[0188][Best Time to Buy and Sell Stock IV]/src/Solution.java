/**
 * @author ZHONGPENG769
 * @date 2019/9/19
 */
public class Solution {

    /**
     * Say you have an array for which the i-th element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * <p>
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     * Example 2:
     * <p>
     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
     * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * <p>
     * 123. Best Time to Buy and Sell Stock III 这题是最多能交易2次，而这题是最多k次
     * <p>
     * <p>
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     * = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     * <p>
     * 类似题目：
     * [LeetCode] 121. Best Time to Buy and Sell Stock 买卖股票的最佳时间
     * [LeetCode] 122. Best Time to Buy and Sell Stock II 买卖股票的最佳时间 II
     * [LeetCode] 123. Best Time to Buy and Sell Stock III 买卖股票的最佳时间 III
     * [LeetCode] 309. Best Time to Buy and Sell Stock with Cooldown 买卖股票的最佳时间有冷却期
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // 次数够用，还有多的
        if (k >= len / 2) {
            return quickSolve(prices);
        }
        int[][] dp = new int[k + 1][len];
        // 次数的循环
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            // 天的循环
            for (int j = 1; j < len; j++) {
                // j-1天，i次的最大交易结果
                // prices[j] + max(dp[i-1, jj] - prices[jj]), 局部最优解+prices[j]
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                // j-1天，已经达到目前最大；j天，不做交易，局部最优解
                // j-1天，第i-1次卖出；j天，第i次买入  +[i-1] - prices[j]，局部最优解
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
