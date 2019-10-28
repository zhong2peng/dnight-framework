import java.math.BigInteger;

/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Additive number is a string whose digits can form additive sequence.
     * <p>
     * A valid additive sequence should contain at least three numbers.
     * Except for the first two numbers, each subsequent number in the
     * sequence must be the sum of the preceding two.
     * <p>
     * Given a string containing only digits '0'-'9', write a function to
     * determine if it's an additive number.
     * <p>
     * Note: Numbers in the additive sequence cannot have leading zeros,
     * so sequence 1, 2, 03 or 1, 02, 3 is invalid.
     * <p>
     * Example 1:
     * <p>
     * Input: "112358"
     * Output: true
     * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
     * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * Example 2:
     * <p>
     * Input: "199100199"
     * Output: true
     * Explanation: The additive sequence is: 1, 99, 100, 199.
     * 1 + 99 = 100, 99 + 100 = 199
     *
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(j, i) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isValid(x1, x2, j + i, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length()) {
            return true;
        }
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }
}
