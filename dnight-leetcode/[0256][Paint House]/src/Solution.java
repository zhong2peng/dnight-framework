/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
     * The cost of painting each house with a certain color is different.
     * You have to paint all the houses such that no two adjacent houses have the same color.
     * <p>
     * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
     * For example,
     * costs[0][0] is the cost of painting house 0 with color red;
     * costs[1][2] is the cost of painting house 1 with color green,
     * and so on...
     * <p>
     * Find the minimum cost to paint all houses.
     * <p>
     * example:
     * Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
     * <p>
     * [0,2],[1,3],[2,2]
     * house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10
     * <p>
     * Note:
     * All costs are positive integers.
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length != 3) {
            return 0;
        }
        int len = costs.length - 1;
        int[][] dp = new int[len + 1][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + costs[i][0], dp[i - 1][2] + costs[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + costs[i][1], dp[i - 1][2] + costs[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + costs[i][2], dp[i - 1][1] + costs[i][2]);
        }

        return Math.min(dp[len][0], Math.min(dp[len][1], dp[len][2]));
    }
}
