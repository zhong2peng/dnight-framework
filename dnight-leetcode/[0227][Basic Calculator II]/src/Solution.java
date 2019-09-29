/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Implement a basic calculator to evaluate a simple expression string.
     * <p>
     * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
     * The integer division should truncate toward zero.
     * <p>
     * Example 1:
     * <p>
     * Input: "3+2*2"
     * Output: 7
     * Example 2:
     * <p>
     * Input: " 3/2 "
     * Output: 1
     * Example 3:
     * <p>
     * Input: " 3+5 / 2 "
     * Output: 5
     * Note:
     * <p>
     * You may assume that the given expression is always valid.
     * Do not use the eval built-in library function.
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, num = 0, opt = 0, res = 0;
        int sign = 1;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                if (opt == 1) num = left * num;
                if (opt == -1) num = left / num;
                opt = 0;

                if (c == '+' || c == '-') {
                    res += sign * num;
                    sign = c == '+' ? 1 : -1;
                } else if (c == '*' || c == '/') {
                    left = num;
                    opt = c == '*' ? 1 : -1;
                }
                num = 0;
            }
        }

        if (opt == 1) {
            res += sign * left * num;
        } else if (opt == -1) {
            res += sign * left / num;
        } else {
            res += sign * num;
        }
        return res;
    }
}
