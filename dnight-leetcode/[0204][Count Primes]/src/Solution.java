/**
 * @author ZHONGPENG769
 * @date 2019/9/26
 */
public class Solution {

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     * <p>
     * Example:
     * <p>
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     * <p>
     * 我们从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，
     * 然后到下一个质数3，标记其所有倍数，一次类推，直到根号n，此时数组中未被标记的数字就是质数。
     * 我们需要一个 n-1 长度的 bool 型数组来记录每个数字是否被标记，长度为 n-1 的原因是题目说是小于n的质数个数，并不包括n。
     * 然后来实现埃拉托斯特尼筛法，难度并不是很大
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        // 默认值是false, 如果是不是素数我们标为true
        boolean[] f = new boolean[n];
        // 最多的素数个数, 所有的偶数都不是素数，所有我们可以剔除一半
        // 但是你可能会有疑问 2 不是偶数吗   --> 这里 2 和 1 相抵消
        int count = n / 2;

        // 之后我们只要剔除 在这个奇数范围内 不是素数的数就可以了
        // 因为我们已经把偶数去掉了，所以只要剔除奇数的奇数倍就可以了
        for (int i = 3; i * i < n; i += 2) {
            if (f[i]) {
                continue;
            }
            // 我们要剔除的是 i 的 奇数倍
            // 为什么是 i * i开始呢   我们打个比方，假设我们此时i = 5
            // 那么我们开始剔除  j = 1 时就是本身，此时要么已经被剔除，要么就是素数，所以 1 不考虑, 3*5 5*3 理解就应该从i*i出发
            // 当 j = 2 || j = 4时，乘积为偶数所以也不在我们考虑范围内
            // 当 j = 3时，我们考虑 3 * 5 但是这种情况已经是当 i = 3的时候被考虑进去了所以我们只要考虑之后的就可以了
            //
            // 那么为什么 j = j + i * 2呢
            // 根据上面所说 我们从3开始考虑 3 * 3,3 * 5,3 * 7....只要 j < n 我们就剔除
            // 带入i : i * i, i * ( i + 2 ) , i * ( i + 4 )....
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }


}
