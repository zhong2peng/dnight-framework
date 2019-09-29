import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * <p>
     * Note: The algorithm should run in linear time and in O(1) space.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,3]
     * Output: [3]
     * Example 2:
     * <p>
     * Input: [1,1,1,3,3,2,2,2]
     * Output: [1,2]
     * <p>
     * 找出一个数组中出现次数超过⌊ n/3 ⌋次的所有数字
     * 数组中出现次数超过⌊ n/3 ⌋次的最多有两个！因为如果3个的话，这三个数字的总次数 > 3×⌊ n/3 ⌋ = n，不可能的。
     * <p>
     * Ｍ投票算法（Boyer-Moore Majority Vote algorithm），这种算法是设置一个数的计数器，在遍历数组的时候，
     * 如果是这个数，则计算器加一，不是则减一，用来计数超过一半的数非常方便。
     * 在这里我们需要进行改进一下，设置两个计数器，来统计两个数出现的次数。
     * <p>
     * 如果是这两个数中的一个，则他的计算器加１，如果不是这两个数中的任何一个，则计算器都减１，如果计数器为０了，
     * 则统计当前的这个数。那么如果一个数出现次数超过1/3，则最后必然出现在统计的数中，
     * 但是我们不能确定现在得到的这两个数出现次数是否超过1/3，因此最后需要再验证一下。
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int c1 = 0, c2 = 0;
        Integer m1 = null, m2 = null;
        for (int i = 0; i < n; i++) {
            if (m1 != null && nums[i] == m1) {
                c1++;
            } else if (m2 != null && nums[i] == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                m2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (m1 != null && nums[i] == m1) {
                c1++;
            }
            if (m2 != null && nums[i] == m2) {
                c2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (c1 > n / 3) res.add(m1);
        if (c2 > n / 3) res.add(m2);
        return res;
    }
}
