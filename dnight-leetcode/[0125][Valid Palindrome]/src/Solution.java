/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Given a string, determine if it is a palindrome,
     * considering only alphanumeric characters and ignoring cases.
     * <p>
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     * <p>
     * Input: "race a car"
     * Output: false
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;

        int delta = 'A' - 'a';
        char l;
        char r;

        while (left < right) {
            while (left < s.length() && !isAlphanumericCharacters(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !isAlphanumericCharacters(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                l = s.charAt(left);
                r = s.charAt(right);
                if (l == r || l - r == delta || r - l == delta) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphanumericCharacters(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z';
    }
}
