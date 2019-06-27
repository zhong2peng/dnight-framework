/**
 * @author ZHONGPENG769
 * @date 2019/6/26
 */
public class Solution1 {

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
     *
     * </pre>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = i;
                index++;
            }
        }
        return index;
    }
}
