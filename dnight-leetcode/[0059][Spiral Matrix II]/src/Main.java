/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = solution.generateMatrix(10);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }
}
