/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] num = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(num));
        System.out.println(solution.minPathSum2(num));
    }
}
