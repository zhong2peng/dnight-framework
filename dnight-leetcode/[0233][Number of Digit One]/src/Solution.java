/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
     * <p>
     * Example:
     * <p>
     * Input: 13
     * Output: 6
     * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
     * <p>
     * 给定一个整数n，计算所有小于等于n的非负整数中数字1出现的个数。
     * 每10个数, 有一个个位是1,
     * 每100个数, 有10个十位是1,
     * 每1000个数, 有100个百位是1. 
     * 做一个循环, 每次计算单个位上1得总个数(个位,十位, 百位). 
     * <p>
     * 例子:
     * <p>
     * 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况:
     * <p>
     *     case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
     * <p>
     *     case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
     * <p>
     *     case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.
     * <p>
     * 以上三种情况可以用 一个公式概括:
     * <p>
     * (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            //   int a = n/m, b = n%m;
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        }
        return ones;
    }

    public int countDigitOne1(int n) {
        if (n <= 0) return 0;
        if (n < 10) return 1;

        int based = (int) Math.pow(10, String.valueOf(n).length() - 1);
        int v = n % based;
        int cfirst = n / based;
        if (cfirst == 1) {
            return v + 1 + countDigitOne(v) + countDigitOne(based - 1);
        } else {
            return based + countDigitOne(v) + countDigitOne(based - 1) * cfirst;
        }
    }
}
