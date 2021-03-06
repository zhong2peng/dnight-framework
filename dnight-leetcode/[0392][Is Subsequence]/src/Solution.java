import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/25
 */
public class Solution {

    /**
     * Given a string s and a string t, check if s is subsequence of t.
     * <p>
     * You may assume that there is only lower case English letters in both s and t.
     * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
     * <p>
     * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
     * of the characters without disturbing the relative positions of the remaining characters.
     * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     * <p>
     * Example 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * Return true.
     * <p>
     * Example 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * Return false.
     * <p>
     * Follow up:
     * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
     * and you want to check one by one to see if T has its subsequence.
     * In this scenario, how would you change your code?
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char tmp : chars1) {
            queue.add(tmp);
        }
        int pos = 0;
        int ori = 0;
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            for (int i = pos, len = chars2.length; i < len; i++) {
                if (chars2[i] == cur) {
                    pos = i + 1;
                    ori++;
                    break;
                }
            }
        }
        return ori == chars1.length;
    }

    public boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isSubsequence("", "ahbgdc");
    }
}
