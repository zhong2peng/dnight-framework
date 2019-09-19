/**
 * @author ZHONGPENG769
 * @date 2019/9/19
 */
public class Solution {

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: 00000010100101000001111010011100
     * Output: 00111001011110000010100101000000
     * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
     * Example 2:
     * <p>
     * Input: 11111111111111111111111111111101
     * Output: 10111111111111111111111111111111
     * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
     * <p>
     * <p>
     * Note:
     * <p>
     * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
     * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
     * <p>
     * <p>
     * Follow up:
     * <p>
     * If this function is called many times, how would you optimize it?
     * <p>
     * 翻转32位无符号整型数。
     * <p>
     * 比如给出输入为 43261596 （二进制表示为 00000010100101000001111010011100），返回 964176192 （二进制表示为 00111001011110000010100101000000）。
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
