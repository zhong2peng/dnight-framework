/**
 * @author ZHONGPENG769
 * @date 2019/9/9
 */
public class Solution {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p>
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * <p>
     * Example:
     * <p>
     * Input: "aab"
     * Output: 1
     * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
     * <p>
     * 可以在任意位置切割字符串，需要保证切割后的每个子串都是回文串。问最少需要切割几次。
     * <p>
     * DP解法的两个步骤，定义dp数组和找状态转移方程
     * <p>
     * 定义状态f(i,j) 表示区间[i,j] 之间最小的cut 数，则状态转移方程为
     * f(i, j) = min {f(i, k) + f(k + 1, j)} ; i < k < j; 0 < i < j < n
     * <p>
     * 一维DP。如果每次，从i 往右扫描，每找到一个回文就算一次DP 的话，就可以
     * 转换为f(i)= 区间[i, n-1] 之间最小的cut 数，n 为字符串长度，则状态转移方程为
     * f(i) = min {f(j + 1) + 1} ; i <= j < n
     * <p>
     * 定义状态P[i][j] = true [i,j]段为回文，那么
     * P[i][j] = str[i] == str[j] && P[i+1][j-1]
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] p = new boolean[n][];

        for (int i = 0; i < n; i++) {
            dp[i] = i;
            p[i] = new boolean[n];

            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (i - j < 2 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
