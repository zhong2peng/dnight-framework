/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Solution {

    /**
     * Given n, how many structurally unique BST's
     * (binary search trees) that store values 1 ... n?
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: 5
     * Explanation:
     * Given n = 3, there are a total of 5 unique BST's:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * <p>
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n == 0) {
            return 0;
        }
        for (int len = 1; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                int left = root - 1;
                int right = len - root;
                dp[len] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
