/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solution solution = new Solution();
        solution.rotate(matrix);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + ", ");
            }
            System.out.println();
        }
    }

}
