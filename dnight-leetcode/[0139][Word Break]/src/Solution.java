import java.util.*;

/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * <p>
     * Note:
     * <p>
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     * <p>
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * <p>
     * 题目大意：
     * 给定一个字符串s和单词字典dict，确定s是否可以分割成一个或多个单词空格分隔的序列。
     * <p>
     * 回溯法
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            for (int i = curIdx + 1; i <= s.length(); i++) {
                if (visited.contains(i)) {
                    continue;
                }
                if (wordDict.contains(s.substring(curIdx, i))) {
                    if (i == s.length()) {
                        return true;
                    }
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }


    /////////////////////////////////////////////////////////////////////
    ////////////////////////////下方为DP解法///////////////////////////////
    /////////////////////////////////////////////////////////////////////

    /**
     * a suffix-based dynamic programming approach (with a 1D "dp" array)
     * process suffixes starting with the last character in the input.
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
        // Insert empty set after last character.
        int cols = s.length() + 1;
        // s的各个位置可达最优长度
        int[] dp = new int[cols];
        dp[cols - 1] = 0;
        // for each character
        for (int j = cols - 2; j >= 0; j--) {
            // Number of characters avaliable to match with
            int nCharsAvail = s.length() - j;
            dp[j] = 0;
            // Each word in the dict
            for (String word : wordDict) {
                // Check for enough characters to match to
                if (nCharsAvail >= word.length()) {
                    // Get score of the suffix to this match site
                    int suffixScore = dp[j + word.length()];
                    // 当前位置所能达到的字符串长度
                    int scorePotential = word.length() + suffixScore;
                    // 剩余的字符串长度能和dp对应的分数匹配
                    if (scorePotential == nCharsAvail) {
                        if (isMatchStartingAt(s, j, word)) {
                            dp[j] = scorePotential;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0] == s.length();
    }

    /**
     * Check for a match of the given word at the starting index of the input s.
     *
     * @param s
     * @param sStartIndex
     * @param word
     * @return
     */
    private boolean isMatchStartingAt(String s, int sStartIndex, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(sStartIndex + i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
