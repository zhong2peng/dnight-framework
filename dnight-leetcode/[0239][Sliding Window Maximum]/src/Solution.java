import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given an array nums, there is a sliding window of size k
     * which is moving from the very left of the array to the very right.
     * You can only see the k numbers in the window.
     * Each time the sliding window moves right by one position.
     * Return the max sliding window.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * <p>
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     * <p>
     * Follow up:
     * Could you solve it in linear time?
     * <p>
     * Hard
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        // 存放结果
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 删除能容忍的最小索引
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // 保证queue的顺序
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            // 存放结果
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }
}
