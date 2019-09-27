/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
     * Find and return the shortest palindrome you can find by performing this transformation.
     * <p>
     * Example 1:
     * <p>
     * Input: "aacecaaa"
     * Output: "aaacecaaa"
     * Example 2:
     * <p>
     * Input: "abcd"
     * Output: "dcbabcd"
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}
