import java.util.ArrayList;
import java.util.List;

/**
 * Author: dnight
 * Date: 2019/8/12 21:50
 */
public class Solution {

    /**
     * The gray code is a binary numeral system
     * where two successive values differ in only one bit.
     * <p>
     * Given a non-negative integer n representing the total number of bits in the code,
     * print the sequence of gray code.
     * A gray code sequence must begin with 0.
     * 生成 n 位格雷码，所谓格雷码，就是连续的两个数字，只有一个 bit 位不同。
     * <p>
     * n = 2 的解
     * 00 - 0
     * 10 - 2
     * 11 - 3
     * 01 - 1
     * <p>
     * n = 3 的解，最高位是 0
     * 000 - 0
     * 010 - 2
     * 011 - 3
     * 001 - 1
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> gray = new ArrayList<>();
        for (int binary = 0; binary < 1 << n; binary++) {
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }
}
