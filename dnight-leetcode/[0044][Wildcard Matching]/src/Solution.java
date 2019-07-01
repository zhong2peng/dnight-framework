/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
     * <p>
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     * <p>
     * Note:
     * <p>
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch(String str, String pattern) {
        //匹配串的索引
        int s = 0;
        //模式串的索引
        int p = 0;
        //记录匹配的匹配位置
        int match = 0;
        //星号的起始索引
        int starIdx = -1;
        while (s < str.length()) {
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                // 记录最后一次发现*的位置
                starIdx = p;
                // 记录在匹配串中匹配*时的位置
                match = s;
                // 模式串索引向前推进
                p++;
            } else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            } else {
                return false;
            }
        }

        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }

        return p == pattern.length();
    }
}
