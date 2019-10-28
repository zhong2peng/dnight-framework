/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Given two non-negative integers num1 and num2 represented as string,
     * return the sum of num1 and num2.
     * <p>
     * Note:
     * <p>
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] chars1;
        char[] chars2;
        if (len1 > len2) {
            chars1 = num2.toCharArray();
            chars2 = num1.toCharArray();
        } else {
            chars1 = num1.toCharArray();
            chars2 = num2.toCharArray();
        }
        len1 = chars1.length - 1;
        len2 = chars2.length - 1;
        StringBuilder sb = new StringBuilder();
        int rad = 0;
        while (len1 >= 0) {
            int tmp = (chars1[len1] - '0') + (chars2[len2] - '0') + rad;
            rad = tmp / 10;
            sb.insert(0, tmp % 10);
            len1--;
            len2--;
        }
        while (len2 >= 0) {
            if (rad > 0) {
                int tmp = rad + (chars2[len2] - '0');
                rad = tmp / 10;
                sb.insert(0, tmp % 10);
            } else {
                sb.insert(0, chars2[len2]);
            }
            len2--;
        }
        if (rad > 0) {
            sb.insert(0, rad);
        }
        return sb.toString();
    }

    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addStrings("98", "9");
        System.out.println(s);
    }
}
