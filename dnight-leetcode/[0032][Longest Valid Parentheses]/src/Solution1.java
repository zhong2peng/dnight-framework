import java.util.Stack;

/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class Solution1 {

    /**
     * <pre>
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     *
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * Another example is ")()())", where the longest valid parentheses substring is "()()",
     * which has length = 4.
     *
     * 题目大意：
     * 给定一个字符串，只包含小括号号，求最长的合法的小括号的数目
     *
     * 解题思路：
     * 使用栈来实现
     * </pre>
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !st.isEmpty() && s.charAt(st.peek()) == '(') {
                st.pop();
                max = Math.max(max, i - ((st.isEmpty()) ? -1 : st.peek()));
            } else {
                st.push(i);
            }
        }
        return max;
    }
}
