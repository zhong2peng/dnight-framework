/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution1 {

    /**
     * 思路: 一个基本的思想就是确定了第一个和第二个数之后, 以后的数就是验证了, 所以只要枚举第一和第二个数,
     * 然后不断验证下面的字符串子串是否是前两个数的和即可. 因为数字可能超出整数的范围,
     * 因此在验证一个数是否是另外两个和的时候, 可以用字符串相加来模拟整数相加.
     * 另外需要注意的是'0'字符, 如果他在子串的首位, 那么他只能以"0"的形式存在.
     */

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) {
            return false;
        }
        if (num.charAt(i) == '0' && j > 1) {
            return false;
        }
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
