/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * <p>
     * Example:
     * <p>
     * Input: 38
     * Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
     * Since 2 has only one digit, return it.
     * Follow up:
     * Could you do it without any loop/recursion in O(1) runtime?
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        int sum = num;
        while (sum > 10) {
            sum = 0;
            while (num > 10) {
                sum += num % 10;
                num /= 10;
            }
            sum += num;
            num = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }

    public int addDigits1(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }
}
