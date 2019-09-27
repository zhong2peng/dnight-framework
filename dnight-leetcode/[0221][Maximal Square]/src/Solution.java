/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's
     * and return its area.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * Output: 4
     * <p>
     * 给出了一个二维的数组，求在这里面能够成的最大的正方形面积是多少。
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0, rows = matrix.length, cols = matrix[0].length;

        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // 1   1   1
                    // 1   2   2
                    // 1   2   3
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
