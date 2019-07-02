import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Solution {

    /**
     * <pre>
     * 利用康托编码的思路，假设有n 个不重复的元素，第k 个排列是a1; a2; a3; :::; an，那么a1 是
     * 哪一个位置呢？
     * 我们把a1 去掉，那么剩下的排列为a2; a3; :::; an, 共计n-1 个元素，n-1 个元素共有(n-1)!
     * 个排列，于是就可以知道a1 = k/(n - 1)!。
     * 同理，a2; a3; :::; an 的值推导如下：
     * k2 = k%(n - 1)!
     * a2 = k2/(n - 2)!
     * ...
     * k(n-1) = k(n-2)%2!
     * a(n-1) = k(n-1)/1!
     * an = 0
     * </pre>
     * <p>
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * <p>
     * Note:
     * <p>
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     * <p>
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     * <p>
     * Input: n = 4, k = 9
     * Output: "2314"
     * 给定ｎ个数字让求第k个序列．ｎ个数字总共的全排列最多有n!个，并且全排列有个规律．
     * 给定一个n，以１开头的排列有(n-1)!个，同样对２和３也是，所以如果k小于等于(n-1)!，
     * 那么首位必为１，因为以１开头的全排列有(n-1)!个．
     * <p>
     * 同样如果k大于(n-1)!，那么第一个数就应该为(k-1)/(n-1)! + 1．这样找到了首位数字应该是哪个，
     * 剩下了(n-1)个数字，我们只需要再重复上面的步骤，不断缩小k即可
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> num = new ArrayList<>();
        //记录最大的阶乘数
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        int index;
        // l = k - 1;为了方便从0开始计数
        for (int i = 0, l = k - 1; i < n; i++) {
            // 从最大的阶乘数开始减少
            // fact的值说明，如果从 __1____ -> _2____ 至少要经过fact次变换
            fact /= (n - i);
            // 计算剩下的数据中的索引
            // 说明类似 __1____ -> _2____ 的变化可以做 index 次，0表示不用变
            index = (l / fact);
            // 将索引值添加到结果中
            // 每做一次__1____ -> _2____ 的变化，表示在num中取后一个更大的值
            sb.append(num.remove(index));
            // 余下要处理的数
            l -= index * fact;
        }
        return sb.toString();
    }

    public String getPermutation1(int n, int k) {
        int temp = n;
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        while (k > 0) {
            int fabNum = fab(n - 1);
            int index = (k - 1) / fabNum + 1;
            while (used[index - 1]) {
                index++;
            }
            used[index - 1] = true;
            sb.append(index);
            n--;
            k -= fabNum;
        }
        for (int i = 0; i < temp; i++) {
            if (used[i] == false) {
                sb.append(i + 1);
                break;
            }
        }
        return sb.toString();
    }

    public int fab(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            return n * fab(n - 1);
        }
    }
}
