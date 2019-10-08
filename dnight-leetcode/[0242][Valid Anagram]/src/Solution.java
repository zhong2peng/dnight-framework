/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "rat", t = "car"
     * Output: false
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * <p>
     * Follow up:
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     * <p>
     * 想要判断两个字符串是不是“重排”的，只用看字符串中字符出现的次数是不是一一对应就好了
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
