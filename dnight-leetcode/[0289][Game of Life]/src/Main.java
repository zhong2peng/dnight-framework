/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        solution.gameOfLife(nums);
        for (int[] tmp : nums) {
            for (int i : tmp) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
