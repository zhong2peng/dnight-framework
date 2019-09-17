/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Given two strings S and T, determine if they are both one edit distance apart.
     * Note:
     * <p>
     * There are 3 possiblities to satisify one edit distance apart:
     * <p>
     * Insert a character into s to get t
     * Delete a character from s to get t
     * Replace a character of s to get t
     * Example 1:
     * <p>
     * Input: s = "ab", t = "acb"
     * Output: true
     * Explanation: We can insert 'c' into s to get t.
     * Example 2:
     * <p>
     * Input: s = "cab", t = "ad"
     * Output: false
     * Explanation: We cannot get t from s by only one step.
     * Example 3:
     * <p>
     * Input: s = "1203", t = "1213"
     * Output: true
     * Explanation: We can replace '0' with '1' to get t.
     * <p>
     * 这道题只让我们判断两个字符串的编辑距离是否为1，那么我们只需分下列三种情况来考虑就行了：
     * <p>
     * 1. 两个字符串的长度之差大于1，那么直接返回False
     * <p>
     * 2. 两个字符串的长度之差等于1，那么长的那个字符串去掉一个字符，剩下的应该和短的字符串相同
     * <p>
     * 3. 两个字符串的长度之差等于0，那么两个字符串对应位置的字符只能有一处不同。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int i = 0;
        int j = 0;
        for (; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            } else {
                return s.substring(i + 1).equals(t.substring(j)) ||
                        s.substring(i).equals(t.substring(j + 1)) ||
                        s.substring(i + 1).equals(t.substring(j + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
