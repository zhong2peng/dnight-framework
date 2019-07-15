/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] num = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(num));
        System.out.println(solution.uniquePathsWithObstacles2(num));
    }
}
