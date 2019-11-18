/**
 * @author ZHONGPENG769
 * @date 2019/11/17
 */
public class Solution {

    /**
     * The Hamming distance between two integers is the number of positions
     * at which the corresponding bits are different.
     * <p>
     * Given two integers x and y, calculate the Hamming distance.
     * <p>
     * Note:
     * 0 ≤ x, y < 231.
     * <p>
     * Example:
     * <p>
     * Input: x = 1, y = 4
     * <p>
     * Output: 2
     * <p>
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * <p>
     * The above arrows point to positions where the corresponding bits are different.
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int distance = 0;
        int lastXbit = 0;
        int lastYbit = 0;

        while (x > 0 || y > 0) {
            lastXbit = x % 2;
            lastYbit = y % 2;
            x /= 2;
            y /= 2;

            if (lastXbit != lastYbit) {
                distance++;
            }
        }
        return distance;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
