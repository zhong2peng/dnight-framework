/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p>
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * <p>
     * 给一个数组代表股票每天的价格。你最多可以买入卖出两次，但只有卖出了才可以再次买入，求出最大的收益是多少。
     * <p>
     * 状态机解法
     * 每天我们其实是有四个状态，买入当前价格的股票，以当前价格的股票卖出。第二次买入股票，第二次卖出股票。
     * <p>
     * s0代表初始状态，初始时钱是 0。
     * s1代表第一次买入后当前的钱，
     * s2代表第一次卖出后当前的钱，
     * s3代表第二次买入后当前的钱，
     * s4代表第二次卖出后当前的钱。
     * 然后我们只需要更新每天的这四个状态即可。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        int s3 = s2;
        int s4 = s2;

        for (int i = 1; i < prices.length; i++) {
            // 买入价格更低的股
            s1 = Math.max(s1, -prices[i]);
            // 卖出当前股，或不操作
            s2 = Math.max(s2, s1 + prices[i]);
            // 第二次买入，或者不操作
            s3 = Math.max(s3, s2 - prices[i]);
            // 第二次卖出，或者不操作
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(0, s4);
    }
}
