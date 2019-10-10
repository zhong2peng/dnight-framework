/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * There are a row of n houses, each house can be painted with one of the k colors.
     * The cost of painting each house with a certain color is different.
     * You have to paint all the houses such that no two adjacent houses have the same color.
     * <p>
     * The cost of painting each house with a certain color is represented by a n x k cost matrix.
     * For example,
     * costs[0][0] is the cost of painting house 0 with color 0;
     * costs[1][2] is the cost of painting house 1 with color 2,
     * and so on...
     * Find the minimum cost to paint all houses.
     * <p>
     * Note:
     * All costs are positive integers.
     * <p>
     * Follow up:
     * Could you solve it in O(nk) runtime?
     *
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int minCost = 0, secondMinCost = 0, lastColor = -1;
        for (int[] cost : costs) {
            // 本次计算的值
            int curMin = Integer.MAX_VALUE;
            int curSecondMin = Integer.MAX_VALUE;
            int curColor = -1;
            // 本次粉刷房子，选择颜色的时候
            for (int j = 0; j < cost.length; j++) {
                int curCost = cost[j] + (j == lastColor ? secondMinCost : minCost);
                if (curCost < curMin) {
                    curSecondMin = curMin;
                    curMin = curCost;
                    curColor = j;
                } else if (curCost < curSecondMin) {
                    curSecondMin = curCost;
                }
            }
            minCost = curMin;
            secondMinCost = curSecondMin;
            lastColor = curColor;
        }
        return minCost;
    }
}
