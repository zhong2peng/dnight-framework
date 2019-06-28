
/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class Solution1 {

    /**
     * <pre>
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its
     * index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * 题目大意：
     * 假设一个排序的数组以一个未知的的枢轴旋转。（即，0 1 2 4 5 6 7可能成为4 5 6 7 0 1 2）。
     * 给定一个目标值，在数组中搜寻。如果存在就返回其对应的下标，否则返回-1。
     * 假设数组中不存在重复值。
     *
     * 解题思路：
     * 找旋转数组最小值的位置minIndex（见LeetCode第153题 ），如果minIndex不为，说明其在分隔成
     * 两个有序数组，并且前一个中的第一个元素都大于后一个数组的每一个元素，判断target中哪一个数组区
     * 间中使用二叉搜索算法查找，如果minIndex=0，说明全局有序，对整个数组进行二叉查找，返回查找结果
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            int minIndex = searchMinIndex(nums, 0, nums.length - 1);
            if (minIndex == 0) {
                return binarySearch(nums, 0, nums.length - 1, target);
            } else {
                if (nums[nums.length - 1] == target) {
                    return nums.length - 1;
                } else if (nums[nums.length - 1] > target) {
                    return binarySearch(nums, minIndex, nums.length - 1, target);
                } else {
                    return binarySearch(nums, 0, minIndex - 1, target);
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start < end) {
            mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    private int searchMinIndex(int[] nums, int start, int end) {
        int mid;
        while (start < end) {
            mid = (end + start) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //说明整个数组都是有序的
        return 0;
    }
}
