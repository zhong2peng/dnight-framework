/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction
     * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * <p>
     * 题目大意：
     * 给一个数组prices[]，prices[i]代表股票在第i天的售价，求出只做一次交易(一次买入和卖出)能得到的最大收益。
     * <p>
     * 解题思路：
     * 分析
     * 贪心法，分别找到价格最低和最高的一天，低进高出，注意最低的一天要在最高的一天之前。
     * 把原始价格序列变成差分序列，本题也可以做是最大m子段和，m = 1。
     * <p>
     * 只需要找出最大的差值即可，即 max(prices[j], prices[i]) ，i < j。一次遍历即可，在遍历的时间用遍历
     * low记录 prices[0, ..., i] 中的最小值，就是当前为止的最低售价，时间复杂度为 O(n)。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        // 第i天的价格可以看作是买入价也可以看作是卖出价
        for (int i = 1; i < prices.length; i++) {
            // 找到更低的买入价
            if (min > prices[i]) {
                min = prices[i];
            } else {
                // 当天的价格不低于买入价
                if (profit < prices[i] - min) {
                    profit = prices[i] - min;
                }
            }
        }
        return profit;
    }

}
