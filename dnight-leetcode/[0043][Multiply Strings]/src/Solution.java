/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * Given two non-negative integers num1 and num2 represented as strings,
     * return the product of num1 and num2, also represented as a string.
     * <p>
     * Note:
     * <p>
     * The length of both num1 and num2 is < 110.
     * Both num1 and num2 contain only digits 0-9.
     * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        int mul;
        int index;
        int temp;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 积的最低位所在的位置
                index = i + j + 1;
                //最低位求和
                pos[index] += mul;
                //进位处理
                while (pos[index] > 9) {
                    temp = pos[index];
                    pos[index] = temp % 10;
                    --index;
                    pos[index] += temp / 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
