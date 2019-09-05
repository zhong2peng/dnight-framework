/**
 * @author ZHONGPENG769
 * @date 2019/9/4
 */
public class Solution {

    /**
     * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
     * <p>
     * A subsequence of a string is a new string which is formed from the original string
     * by deleting some (can be none) of the characters without disturbing the relative
     * positions of the remaining characters.
     * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     * <p>
     * Example 1:
     * <p>
     * Input: S = "rabbbit", T = "rabbit"
     * Output: 3
     * Explanation:
     * <p>
     * As shown below, there are 3 ways you can generate "rabbit" from S.
     * (The caret symbol ^ means the chosen letters)
     * <p>
     * rabbbit
     * ^^^^ ^^
     * rabbbit
     * ^^ ^^^^
     * rabbbit
     * ^^^ ^^^
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[] dp = new int[s_len + 1];
        for (int i = 0; i <= s_len; i++) {
            dp[i] = 1;
        }
        for (int t_i = 1; t_i <= t_len; t_i++) {
            int pre = dp[0];
            dp[0] = 0;
            for (int s_i = 1; s_i <= s_len; s_i++) {
                int temp = dp[s_i];
                if (t.charAt(t_i - 1) == s.charAt(s_i - 1)) {
                    dp[s_i] = dp[s_i - 1] + pre;
                } else {
                    dp[s_i] = dp[s_i - 1];
                }
                pre = temp;
            }
        }
        return dp[s_len];
    }
}
