import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class Solution {

    /**
     * Given a string that contains only digits 0-9 and a target value,
     * return all possibilities to add binary operators (not unary)
     * +, -, or * between the digits so they evaluate to the target value.
     * <p>
     * Example 1:
     * <p>
     * Input: num = "123", target = 6
     * Output: ["1+2+3", "1*2*3"]
     * Example 2:
     * <p>
     * Input: num = "232", target = 8
     * Output: ["2*3+2", "2+3*2"]
     * Example 3:
     * <p>
     * Input: num = "105", target = 5
     * Output: ["1*0+5","10-5"]
     * Example 4:
     * <p>
     * Input: num = "00", target = 0
     * Output: ["0+0", "0-0", "0*0"]
     * Example 5:
     * <p>
     * Input: num = "3456237490", target = 9191
     * Output: []
     *
     * @param num
     * @param target
     * @return
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    private void helper(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                res.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
