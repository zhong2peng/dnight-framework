/**
 * @author ZHONGPENG769
 * @date 2019/10/29
 */
public class Solution {

    /**
     * You have a total of n coins that you want to form in a staircase shape,
     * where every k-th row must have exactly k coins.
     * <p>
     * Given n, find the total number of full staircase rows that can be formed.
     * <p>
     * n is a non-negative integer and fits within the range of a 32-bit signed integer.
     * <p>
     * Example 1:
     * <p>
     * n = 5
     * <p>
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤
     * <p>
     * Because the 3rd row is incomplete, we return 2.
     * Example 2:
     * <p>
     * n = 8
     * <p>
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     * <p>
     * Because the 4th row is incomplete, we return 3.
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            n = n - i;
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.arrangeCoins(3);
        System.out.println(i);

    }
}
