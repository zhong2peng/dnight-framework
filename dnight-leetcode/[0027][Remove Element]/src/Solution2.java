/**
 * @author ZHONGPENG769
 * @date 2019/6/26
 */
public class Solution2 {

    /**
     * <pre>
     * 原题
     * Given an array and a value, remove all instances of that value in place and return the new length.
     *  The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
     *
     * 题目大意
     * 给定一个数组和一个值，删除数组中与这个值相等的元素，并且返回与这个数组的新的长度。
     *
     * 解题思路
     * 从左边找值为elem的元素的位置，j从右边找值不为elem的元素的位置，然后将j位置的数值移动到i位置。
     * </pre>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int exchange = 0;
        // 算法思想：i从左边找值为elem的元素的位置，j从右边找值不为elem的元素的位置，
        // 取等号是让长度为1的数组可以进入
        for (int i = 0, j = nums.length - 1; i <= j; i++) {
            if (nums[i] == val) {
                exchange++;
                // 从数组后面开始向前找第一个不等于elem的元素
                while (j > i && nums[j] == val) {
                    // 有值为elem的元素说明要交换，但是交换过程可以省去
                    exchange++;
                    j--;
                }
                // 情况1：到到不为elem的元素的位置，将j位置的元素放到i位置
                // 情况2：没有找到不elem的元素的位置，即i后的所有元素值都是e，此时有j=i
                // 不论哪种情况将j中的值放入i都没有关系
                nums[i] = nums[j];
                j--;
            }
        }
        return nums.length - exchange;
    }
}
