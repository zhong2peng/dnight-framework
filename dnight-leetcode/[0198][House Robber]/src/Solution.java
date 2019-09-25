/**
 * @author ZHONGPENG769
 * @date 2019/9/25
 */
public class Solution {

    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
     * and it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     * <p>
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     * <p>
     * 每个房间里都有不同数量的财物，给出能抢劫的最大财物数。这里的唯一限制是不能同时对相邻的房间进行抢劫。
     * DP
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //max monney can get if rob current house
        int rob = 0;
        //max money can get if not rob current house
        int notrob = 0;
        for (int i = 0; i < nums.length; i++) {
            // if rob current value, previous house must not be robbed
            int currob = notrob + nums[i];
            // if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            notrob = Math.max(notrob, rob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}
