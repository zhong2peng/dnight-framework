/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Solution {

    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     * <p>
     * For example:
     * <p>
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     * Example 1:
     * <p>
     * Input: 1
     * Output: "A"
     * Example 2:
     * <p>
     * Input: 28
     * Output: "AB"
     * Example 3:
     * <p>
     * Input: 701
     * Output: "ZY"
     * <p>
     * 进制的转换，10进制 -> 26进制，然后用A~Z来替换
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        // 2个注意点，第一，没有0位，代表要处理一下
        // 第二，追加的方式，容易弄反
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; // 没有0位，以26为进制，25代表Z，0代表A，所以要减一
            sb.insert(0, (char) ((n % 26) + 'A'));
            n = n / 26;
        }
        return sb.toString();

    }

    public String convertToTitle1(int n) {
        return n == 0 ? "" : convertToTitle1(--n / 26) + (char) ('A' + (n % 26));
    }

}
