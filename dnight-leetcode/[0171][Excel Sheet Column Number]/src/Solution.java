/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Solution {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = 0;
        Long start = 0L;
        for (int i = len - 1; i >= 0; i--) {
            result += (chars[i] - 'A' + 1) * (int) (Math.pow(26L, start++));
        }
        return result;
    }

    public int titleToNumber1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result += ((s.charAt(i) - 'A') + 1);
        }
        return result;
    }
}
