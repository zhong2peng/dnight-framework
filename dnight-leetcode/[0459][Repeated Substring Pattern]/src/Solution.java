/**
 * @author ZHONGPENG769
 * @date 2019/11/17
 */
public class Solution {

    /**
     * Given a non-empty string check if it can be constructed by
     * taking a substring of it and appending multiple copies of the substring together.
     * You may assume the given string consists of lowercase English letters only and
     * its length will not exceed 10000.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "abab"
     * Output: True
     * Explanation: It's the substring "ab" twice.
     * Example 2:
     * <p>
     * Input: "aba"
     * Output: False
     * Example 3:
     * <p>
     * Input: "abcabcabcabc"
     * Output: True
     * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int m = len / i;
                String subStr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subStr);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    //kmp
    public boolean repeatedSubstringPattern1(String s) {
        int[] next = new int[s.length() + 1];
        int i = 1;
        int j = 0;
        while (i < s.length()) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                next[++i] = j;
            }
        }
        int strSubLen = s.length() - next[s.length()];
        if (strSubLen == s.length() || strSubLen > s.length() / 2) {
            return false;
        }
        for (i = strSubLen; i < s.length(); i++) {
            for (j = 0; j < strSubLen; i++, j++) {
                if (i >= s.length() || s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
