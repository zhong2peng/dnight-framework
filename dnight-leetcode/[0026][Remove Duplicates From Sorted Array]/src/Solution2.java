/**
 * @author ZHONGPENG769
 * @date 2019/6/26
 */
public class Solution2 {

    /**
     * <pre>
     * 原题
     * Given a sorted array, remove the duplicates in place such that each element
     * appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place
     * with constant memory.
     * For example,
     * Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums
     * being 1 and 2 respectively. It doesn’t matter what you leave beyond the new length.
     *
     * 题目大意
     * 给定一个排序的数组，将数组中的重复元素去掉，相同的只保留一个，并且返回数组新的元素个数，
     * 不要创建一个新的数组来保存结果。在常量时间内解决这个问题
     *
     * 解题思路
     * 从第二个元素开始处理，记为当前处理的元素，如果当前元素与他的前一个元素相同就删除这个元素，
     * 如果不同就将它移动到正确的位置，返回最后数组元素人个数。
     * </pre>
     *
     * @param A
     * @return
     */
    public int removeDumplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int index = 0;
        int next = 1;
        while (next < A.length) {
            while (next < A.length && A[index] == A[next]) {
                next++;
            }
            if (next < A.length) {
                index++;
                A[index] = A[next];
                next++;
            }
        }
        return index + 1;
    }
}
