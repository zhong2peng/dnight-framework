/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class Main {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses(")()())()"));
        System.out.println(solution.longestValidParentheses(")()(()()))()()()"));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestValidParentheses("(()"));
        System.out.println(solution2.longestValidParentheses(")()())"));
        System.out.println(solution2.longestValidParentheses(")()())()"));
        System.out.println(solution2.longestValidParentheses(")()(()()))()()()"));
    }
}
