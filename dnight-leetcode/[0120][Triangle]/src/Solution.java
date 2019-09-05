import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Given a triangle, find the minimum path sum from top to bottom.
     * Each step you may move to adjacent numbers on the row below.
     * <p>
     * For example, given the following triangle
     * <p>
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * <p>
     * Note:
     * <p>
     * Bonus point if you are able to do this using only O(n) extra space,
     * where n is the total number of rows in the triangle.
     * 题目大意：
     * 给定一个三角形，找出从顶到底的最小路径和，每一步可以从上一行移动到下一行相邻的数字
     * <p>
     * 解题思路：
     * 递推方程：
     * f(0,0)=a[0][0]
     * f(i,0)=a[i][0]+f(i-1,0) (i>0)
     * f(i,i)=a[i][i]+f(i-1,i-1)(i>0)
     * f(i,j)=a[i][j]+MIN(f(i-1,j),f(i-1,j-1))(0<j<i)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        dp[0][0] = triangle.get(0).get(0);
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }
        for (int i = 0; i < row; i++) {
            minVal = Math.min(dp[row - 1][i], minVal);
        }
        return minVal;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();
        int[] dp = new int[cols];
        for (int row = 1; row < rows; row++) {
            List<Integer> curRow = triangle.get(row);
            int col = curRow.size() - 1;
            dp[col] = dp[col - 1] + curRow.get(col);
            col--;
            for (; col > 0; col--) {
                dp[col] = Math.min(dp[col], dp[col - 1]) + curRow.get(col);
            }
            dp[col] = dp[col] + curRow.get(col);
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < cols; col++) {
            min = Math.min(min, dp[col]);
        }
        return min;
    }
}
