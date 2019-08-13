import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/8/13
 */
public class Solution {

    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
     * <p>
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * Output: true
     * <p>
     * 在两个字符串 s1 和 s2 中依次取字母，问是否可以组成 S3。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Integer> memoization = new HashMap<>();
        return getAns(s1, 0, s2, 0, s3, 0, memoization);
    }

    private boolean getAns(String s1, int i, String s2, int j, String s3, int k, Map<String, Integer> memoization) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        String key = i + "@" + j;
        if (memoization.containsKey(key)) {
            return memoization.getOrDefault(key, -1) == 1;
        }
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            memoization.put(key, 1);
            return true;
        }
        if (i == s1.length()) {
            while (j < s2.length()) {
                if (s2.charAt(j) != s3.charAt(k)) {
                    memoization.put(key, 0);
                    return false;
                }
                j++;
                k++;
            }
            memoization.put(key, 1);
            return true;
        }
        if (j == s2.length()) {
            while (i < s1.length()) {
                if (s1.charAt(i) != s3.charAt(k)) {
                    memoization.put(key, 0);
                    return false;
                }
                i++;
                k++;
            }
            memoization.put(key, 1);
            return true;
        }
        if (s1.charAt(i) == s3.charAt(k)) {
            if (getAns(s1, i + 1, s2, j, s3, k + 1, memoization)) {
                memoization.put(key, 1);
                return true;
            }
        }
        if (s2.charAt(j) == s3.charAt(k)) {
            if (getAns(s1, i, s2, j + 1, s3, k + 1, memoization)) {
                memoization.put(key, 1);
                return true;
            }
        }
        memoization.put(key, 0);
        return false;
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
