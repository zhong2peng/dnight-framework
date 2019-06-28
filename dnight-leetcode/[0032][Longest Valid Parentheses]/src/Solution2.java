import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class Solution2 {

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
        int result = 0;
        int start = 0;

        Deque<Integer> m = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                m.push(i);
            } else if (s.charAt(i) == ')') {
                if (m.isEmpty()) {
                    // 当前的位置已经是无效了，记录下一个位置是开始配对的位置
                    start = i + 1;
                } else {
                    //出栈
                    m.pop();
                    // 如果栈为空，说明从start开始一直匹配，没出现多余的左括号：
                    // 结果就是：Math.max(result, i - start + 1)
                    // 如果栈非空，说明有多余的左括号，最后一个多余的左括号的位置就是m.peek()，
                    // 最大的匹配括号就是: Math.max(result, i - m.peek())
                    result = m.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - m.peek());
                }
            }
        }
        return result;
    }
}
