/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given an array with n objects colored red, white or blue, sort them so that objects
     * of the same color are adjacent, with the colors in the order red, white and blue.
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
     * and blue respectively.
     * Note:
     * You are not suppose to use the library’s sort function for this problem.
     *
     * 题目大意
     * 给定一个对象数组，对象是红色，白色和蓝色，对颜色进行排序，红，白，蓝。
     * 使用0，1，2分别代表红，白，蓝。
     * 注意：不能使用库函数进行排序。
     *
     * 解题思路
     * 用一个数组分别计算0，1，2出现的次数，再将数组赋值
     * </pre>
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int[] count = new int[3];
        for (int n : nums) {
            count[n]++;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < count.length; i++) {
            if (i == 0) {
                start = 0;
            } else {
                start += count[i - 1];
            }
            end += count[i];
            for (int j = start; j < end; j++) {
                nums[j] = i;
            }
        }
    }

    public void sortColors1(int[] A) {
        if (A == null) {
            return;
        }
        int count = 0;
        int sum = 0;
        for (int i : A) {
            if (i == 1) {
                count++;
            }
            sum += i;
        }
        sum = (sum - count) / 2;
        count = A.length - count - sum;
        sum = A.length - sum;

        for (int i = 0; i < count; i++) {
            A[i] = 0;
        }
        for (int i = count; i < sum; i++) {
            A[i] = 1;
        }
        for (int i = sum; i < A.length; i++) {
            A[i] = 2;
        }
    }
}
