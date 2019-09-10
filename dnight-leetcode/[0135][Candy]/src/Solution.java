/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * There are N children standing in a line. Each child is assigned a rating value.
     * <p>
     * You are giving candies to these children subjected to the following requirements:
     * <p>
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     * What is the minimum candies you must give?
     * <p>
     * Example 1:
     * <p>
     * Input: [1,0,2]
     * Output: 5
     * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
     * <p>
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     * <p>
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     * <p>
     * 贪心算法
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int len = ratings.length, sum = 0;
        int[] candies = new int[len];
        candies[0] = 1;
        for (int i = 1; i < len; i++) {
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            candies[i] = Math.max(ratings[i] > ratings[i + 1] ? candies[i + 1] + 1 : 1, candies[i]);
        }
        for (int i = 0; i < len; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
