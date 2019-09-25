import java.util.HashSet;

/**
 * @author ZHONGPENG769
 * @date 2019/9/25
 */
public class Solution {

    /**
     * Write an algorithm to determine if a number is "happy".
     * <p>
     * A happy number is a number defined by the following process:
     * Starting with any positive integer, replace the number by the sum of the squares of its digits,
     * and repeat the process until the number equals 1 (where it will stay),
     * or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy numbers.
     * <p>
     * Example:
     * <p>
     * Input: 19
     * Output: true
     * Explanation:
     * 1^2+9^2=82
     * 8^2+2^2=68
     * 6^2+8^2=100
     * 1^2+0^2+0^2=1
     * <p>
     * 对任意一个正整数，不断各个数位上数字的平方和，若最终收敛为1，则该数字为happy number，否则程序可能从某个数开始陷入循环
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
