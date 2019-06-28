/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * Here are few examples.
     *
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     *
     * 题目大意
     * 给定一个排序数组，和一个指定的值，如果找到这个值，返回这个值位置，如果没有找到，返回这个值在数组中的插入位置。
     * 假设数组中没有重复的元素。
     *
     * 解题思路
     * 一、最直接的查找算法，从左向右搜索。
     * 二、使用二分查找算法。
     * </pre>
     *
     * @param A
     * @param target
     * @return
     */
    public int searchIndex(int[] A, int target) {
        int mid;
        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int searchIndex1(int[] A, int target) {
        if (A == null) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
