/**
 * @author ZHONGPENG769
 * @date 2019/7/18
 */
public class Solution {

    /**
     * <pre>
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array
     *
     * 题目大意：
     * "在旋转数组中搜索值"的后续，如果数组中的值允许重复
     * 写一个程序确定一个给定的值是否在数组中
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            int minIndex = findMinIndex(nums);
            if (minIndex == 0) {
                return binarySearch(nums, 0, nums.length - 1, target);
            } else {
                if (nums[nums.length - 1] == target) {
                    return true;
                } else if (nums[nums.length - 1] > target) {
                    return binarySearch(nums, minIndex, nums.length - 1, target);
                } else {
                    return binarySearch(nums, 0, minIndex, target);
                }
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private int findMinIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (nums[lo] >= nums[hi]) {
            if (hi - lo == 1) {
                mid = hi;
                break;
            }
            mid = (lo + hi) >> 1;
            if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
                return sequenceSearchMinIndex(nums, lo, hi);
            }
            if (nums[mid] >= nums[lo]) {
                lo = mid;
            } else if (nums[mid] <= nums[hi]) {
                hi = mid;
            }
        }
        return mid;
    }

    private int sequenceSearchMinIndex(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return i + 1;
            }
        }
        return start;
    }

    public boolean search1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //无法确定分区
                left++;
            }
        }
        return false;
    }
}
