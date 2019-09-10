/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     * <p>
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
     * You begin the journey with an empty tank at one of the gas stations.
     * <p>
     * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
     * otherwise return -1.
     * <p>
     * Note:
     * <p>
     * If there exists a solution, it is guaranteed to be unique.
     * Both input arrays are non-empty and have the same length.
     * Each element in the input arrays is a non-negative integer.
     * Example 1:
     * <p>
     * Input:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * <p>
     * Output: 3
     * <p>
     * 每个节点表示添加的油量，每条边表示消耗的油量。题目的意思就是问我们从哪个节点出发，还可以回到该节点。只能顺时针方向走。
     * 暴力破解
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        // 记录访问的起始点
        int start = 0;
        // 加的气和消耗的气的总差值
        int total = 0;
        // 从start位置开始，加的气和消耗的气宗差值
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += gas[i] - cost[i];
            }
        }
        return total >= 0 ? start : -1;
    }
}
