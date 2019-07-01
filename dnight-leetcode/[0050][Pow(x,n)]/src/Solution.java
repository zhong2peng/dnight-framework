/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * <pre>
     * Implement pow(x, n).
     *
     * 题目大意：
     * 实现x的n次方
     *
     * 解题方法：
     * 递归求解
     * </pre>
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            throw new IllegalArgumentException();
        }
        //指数正负标志
        boolean isNegative = false;
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        double result = pow(x, n);
        if (isNegative) {
            return 1.0 / result;
        } else {
            return result;
        }
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double result = pow(x, n / 2);
            //n是奇数
            if (n % 2 != 0) {
                return x * result * result;
            } else {
                return result * result;
            }
        }
    }
}
