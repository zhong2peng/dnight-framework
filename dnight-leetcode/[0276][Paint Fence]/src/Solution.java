/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class Solution {

    /**
     * There is a fence with n posts, each post can be painted with one of the k colors.
     * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
     * Return the total number of ways you can paint the fence.
     * <p>
     * Note:
     * n and k are non-negative integers.
     * <p>
     * 1. n == 0，当没有标杆的时候，就没有任何粉刷的可能。
     * <p>
     * 2. n == 1，当只有一根标杆的时候，那就是有几种颜料就又几种粉刷的可能性。
     * <p>
     * 3. 当n >= 2的时候。因为题目条件是最多两个相邻的标杆能够颜色相同，可能性就只有两种，
     * 一种是两根标杆的颜色相同，
     * 另一种就是两根标杆的颜色不同。开始两根标杆的颜色相同的可能性就是颜色的可能性，即k。
     *
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        // same[i] : 第i个post和第i-1个post颜色相同
        int[] same = new int[n];
        // diff[i] : 第i个post和第i-1个post颜色不同
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; i++) {
            same[i] = diff[i - 1];
            diff[i] = (k - 1) * same[i - 1] + (k - 1) * diff[i - 1];
        }
        return same[n - 1] + diff[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(2, 2));
        System.out.println(solution.numWays(2, 3));
    }
}
