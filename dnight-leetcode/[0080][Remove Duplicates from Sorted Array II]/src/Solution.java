/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Solution {

    /**
     * 给定一个数组，每个数字只允许出现 2 次，将满足条件的数字全部移到前边，并且返回有多少数字。
     * 例如 [ 1, 1, 1, 2, 2, 3, 4, 4, 4, 4 ]，
     * 要变为 [ 1, 1, 2, 2, 3, 4, 4 ...] 剩余部分的数字不要求
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 2] < nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
