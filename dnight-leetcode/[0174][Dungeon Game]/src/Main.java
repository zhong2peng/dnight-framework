/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int i = solution.calculateMinimumHP(nums);
        System.out.println(i);

    }
}
