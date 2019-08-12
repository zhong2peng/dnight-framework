/**
 * Author: dnight
 * Date: 2019/8/12 22:17
 */
public class Solution {

    /**
     * A message containing letters from A-Z is being encoded to numbers
     * using the following mapping:
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits,
     * determine the total number of ways to decode it.
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
}
