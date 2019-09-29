import java.util.Stack;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Implement a basic calculator to evaluate a simple expression string.
     * <p>
     * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
     * non-negative integers and empty spaces .
     * <p>
     * Example 1:
     * <p>
     * Input: "1 + 1"
     * Output: 2
     * Example 2:
     * <p>
     * Input: " 2-1 + 2 "
     * Output: 3
     * Example 3:
     * <p>
     * Input: "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     * Note:
     * You may assume that the given expression is always valid.
     * Do not use the eval built-in library function.
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}
