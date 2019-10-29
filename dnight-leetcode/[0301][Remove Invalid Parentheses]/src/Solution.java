import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/29
 */
public class Solution {

    /**
     * 给一个字符串，里面含有'(', ')'和字母，其中的小括号可能不配对，
     * 移除不配对的括号，使得括号匹配，返回所有可能的解。
     * <p>
     * 判断括号是否合法，可以用栈，这也是栈的一个典型应用。也可用一个count计数器，遇到左括号++，右括号--，
     * 一旦count小于0，就说明不合法。比较推荐count方式，空间复杂度较低。
     * <p>
     * 解法1: BFS: 枚举去除的点，当找到后停止BFS树的扩展（因为要去除最少括号，所以即使有其他的结果，也一定在同一层）
     * 解法2: DFS: 统计左右括号能删的个数，进行DFS。
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    private void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }

            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            return;
        }


        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }
}
