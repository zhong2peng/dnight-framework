/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        int i = solution.minCostII(costs);
        System.out.println(i);
    }
}
